package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TelaPrincipal1 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		DespesaForm telaDespesa = new DespesaForm();
		telaDespesa.start();
		
		ReceitaForm telaReceita = new ReceitaForm();
		telaReceita.start();
		
		BorderPane bp = new BorderPane();
		Button btnTelaA = new Button("Despesas");
		btnTelaA.setOnAction((e)-> {
			bp.setCenter(telaDespesa.render());
		});
		Button btnTelaB = new Button("Receitas");
		btnTelaB.setOnAction((e)-> {
			bp.setCenter(telaReceita.render());
		});
		bp.setTop(new HBox(btnTelaA, btnTelaB) );
		Scene scn = new Scene(bp, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Sistema de Gestão de Orçamentaria");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(TelaPrincipal1.class, args);
	}

}
