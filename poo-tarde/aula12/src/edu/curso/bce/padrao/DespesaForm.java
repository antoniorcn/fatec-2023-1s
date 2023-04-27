package edu.curso.bce.padrao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.LocalDateStringConverter;

public class DespesaForm extends Application {
	private TextField txtRazao = new TextField();
	private TextField txtData = new TextField();
	private TextField txtValor = new TextField();
	private DateTimeFormatter dtf = 
			DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	private DespesaControl control = new DespesaControl();
	private TableView<Despesa> table = new TableView<>();
	
	public void limparCampos() { 
		txtRazao.setText("");
		txtData.setText("");
		txtValor.setText("");
	}
			
	public void ligacoes() { 
		Bindings.bindBidirectional(txtRazao.textProperty(), 
				control.razaoProperty());
		Bindings.bindBidirectional(txtValor.textProperty(),
				control.valorProperty(), 
				(StringConverter)new DoubleStringConverter());
		Bindings.bindBidirectional(txtData.textProperty(),
				control.dataProperty(), 
				(StringConverter)new LocalDateStringConverter());
	}
	
	public void adicionar() { 
		control.adicionar();
		Alert a = new Alert(AlertType.INFORMATION, 
				"Despesa adicionada com sucesso", ButtonType.OK);
		a.showAndWait();
		limparCampos();
	}
	
	public void prepararTabela() { 
		TableColumn<Despesa, String> col1 = new TableColumn<>("Raz�o");
		col1.setCellValueFactory(
				new PropertyValueFactory<Despesa, String>("razao")
		);
		TableColumn<Despesa, String> col2 = new TableColumn<>("Data");
		col2.setCellValueFactory( item -> 
			new ReadOnlyStringWrapper(
					dtf.format(item.getValue().getData()) )
		);
		TableColumn<Despesa, Double> col3 = new TableColumn<>("Valor");
		col3.setCellValueFactory(
				new PropertyValueFactory<Despesa, Double>("valor")
		);
		table.getColumns().addAll(col1, col2, col3);
		
		table.setItems(control.getList());
	}
		
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane principal = new BorderPane();
		principal.setPadding(new Insets(50));
		Scene scn = new Scene(principal, 600, 300);
		GridPane painelForm = new GridPane();
		principal.setTop(painelForm);
		principal.setCenter(table);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(30);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(70);
		painelForm.getColumnConstraints().addAll(col1, col2);
		
		Button btnAdicionar = new Button("Adicionar");
		Button btnPesquisar = new Button("Pesquisar");
		
		btnAdicionar.setOnAction((e)->{
			adicionar();
		});
		
		btnPesquisar.setOnAction((e)->{
			control.pesquisar();
		});
		
		
		painelForm.add(new Label("Id"), 0, 0);
		painelForm.add(new Label("Raz�o"), 0, 1);
		painelForm.add(txtRazao, 1, 1);
		painelForm.add(new Label("Data"), 0, 2);
		painelForm.add(txtData, 1, 2);
		painelForm.add(new Label("Valor"), 0, 3);
		painelForm.add(txtValor, 1, 3);
		painelForm.add(btnAdicionar, 0, 4);
		painelForm.add(btnPesquisar, 1, 4);

		stage.setScene(scn);
		stage.setTitle("Controle de Despesas");
		stage.show();
		ligacoes();
		prepararTabela();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
