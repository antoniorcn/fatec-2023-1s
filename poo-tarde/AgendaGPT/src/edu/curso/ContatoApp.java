package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ContatoApp extends Application {
    private TableView<Contato> tabela;
    private TextField nomeField;
    private TextField telefoneField;
    private TextField emailField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gerenciador de Contatos");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);

        tabela = new TableView<>();
        TableColumn<Contato, String> nomeColumn = new TableColumn<>("Nome");
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        TableColumn<Contato, String> telefoneColumn = new TableColumn<>("Telefone");
        telefoneColumn.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());
        TableColumn<Contato, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        tabela.getColumns().add(nomeColumn);
        tabela.getColumns().add(telefoneColumn);
        tabela.getColumns().add(emailColumn);

        nomeField = new TextField();
        telefoneField = new TextField();
        emailField = new TextField();

        Button adicionarButton = new Button("Adicionar");
        adicionarButton.setOnAction(event -> adicionarContato());
        Button editarButton = new Button("Editar");
        editarButton.setOnAction(event -> editarContato());
        Button excluirButton = new Button("Excluir");
        excluirButton.setOnAction(event -> excluirContato());

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().add(new Label("Nome:"));
        hbox.getChildren().add(nomeField);
        hbox.getChildren().add(new Label("Telefone:"));
        hbox.getChildren().add(telefoneField);
        hbox.getChildren().add(new Label("Email:"));
        hbox.getChildren().add(emailField);
        hbox.getChildren().add(adicionarButton);
        hbox.getChildren().add(editarButton);
        hbox.getChildren().add(excluirButton);

        root.setCenter(tabela);
        root.setBottom(hbox);

        primaryStage.show();
    }

    private void adicionarContato() {
        Contato contato = new Contato(nomeField.getText(), telefoneField.getText(), emailField.getText());
        tabela.getItems().add(contato);
        limparCampos();
    }

    private void editarContato() {
        Contato contato = tabela.getSelectionModel().getSelectedItem();
	    if (contato != null) {
	        contato.setNome(nomeField.getText());
	        contato.setTelefone(telefoneField.getText());
	        contato.setEmail(emailField.getText());
	        tabela.refresh();
	        limparCampos();
	    }
	}
	
	private void excluirContato() {
	    Contato contato = tabela.getSelectionModel().getSelectedItem();
	    if (contato != null) {
	        tabela.getItems().remove(contato);
	        limparCampos();
	    }
	}
	
	private void limparCampos() {
	    nomeField.setText("");
	    telefoneField.setText("");
	    emailField.setText("");
	}
}