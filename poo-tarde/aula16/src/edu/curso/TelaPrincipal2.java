package edu.curso;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TelaPrincipal2 extends Application {
	private List<Tela> telas = new ArrayList<>();
	
	public void gerarTelas() { 
		Tela telaDespesa = new DespesaForm();
		Tela telaReceita = new ReceitaForm();
		telas.add(telaDespesa);
		telas.add(telaReceita);
		
		for (Tela t : telas) { 
			t.start();
		}
	}
	
	public Tela getTela(String nome) {
		if ("despesa".equals(nome)) { 
			return telas.get(0);
		} else if ("receita".equals(nome)) {
			return telas.get(1);
		}
		return null;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
	
		gerarTelas();
		
		BorderPane bp = new BorderPane();
		Button btnTelaA = new Button("Despesas");
		btnTelaA.setOnAction((e)-> {
			bp.setCenter(getTela("despesa").render());
		});
		Button btnTelaB = new Button("Receitas");
		btnTelaB.setOnAction((e)-> {
			bp.setCenter(getTela("receita").render());
		});
		bp.setTop(new HBox(btnTelaA, btnTelaB) );
		Scene scn = new Scene(bp, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Sistema de Gestão de Orçamentaria");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal2.class, args);
	}

}
