package edu.curso.fxproperty;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TesteFXProperty extends Application {

	private TextField txtNumero1 = new TextField("0");
	private TextField txtNumero2 = new TextField("0");
	private Label lblResposta = new Label("Resposta: ");
	
	private StringProperty texto1 = new SimpleStringProperty("");
	
	private Button btnTeste = new Button("Mostra variavel");
	
	@Override
	public void start(Stage stage) throws Exception {
		FlowPane fp = new FlowPane();
		Scene scn = new Scene(fp, 200, 200);
		
		fp.getChildren().addAll(new Label("Numero 1:"), txtNumero1);
		fp.getChildren().addAll(new Label("Numero 2:"), txtNumero2);
		fp.getChildren().addAll(lblResposta, btnTeste);
		
		texto1.bind(txtNumero1.textProperty());
		
		txtNumero1.textProperty().addListener(
				(o, antigo, novo)->{
					int r = Integer.parseInt(novo) + 
						Integer.parseInt(txtNumero2.getText());
					lblResposta.setText("Resposta: " + r);
		});
		
		txtNumero2.textProperty().addListener(
				(o, antigo, novo)->{
					int r = Integer.parseInt(novo) + 
							Integer.parseInt(txtNumero1.getText());
						lblResposta.setText("Resposta: " + r);
		});
		
		btnTeste.setOnAction(
				e -> System.out.println(texto1.get()));
		
		stage.setScene(scn);
		stage.setTitle("Teste de Propriedades do JavaFX");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
