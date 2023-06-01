package edu.curso;

import java.time.format.DateTimeFormatter;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LongStringConverter;

public class DespesaForm implements Tela {
	private TextField txtRazao = new TextField();
	private TextField txtData = new TextField();
	private TextField txtValor = new TextField();
	private Label lblId = new Label("");
	private DateTimeFormatter dtf = 
			DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	private DespesaControl control;
	private TableView<Despesa> table = new TableView<>();
	private BorderPane principal;
	private Executor executor;
	
	public DespesaForm(Executor executor) { 
		this.executor = executor;
	}
	
	public DespesaForm() { 
	}
	
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
		Bindings.bindBidirectional(lblId.textProperty(), 
				control.idProperty(),
				(StringConverter)new LongStringConverter());
	}
	
	public void adicionar() { 
		control.salvar();
		Alert a = new Alert(AlertType.INFORMATION, 
				"Despesa adicionada com sucesso", ButtonType.OK);
		a.showAndWait();
		
		control.novo();
	}
	
	public void prepararTabela() { 
		TableColumn<Despesa, String> col1 = new TableColumn<>("Razão");
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
		
		TableColumn<Despesa, Void> col4 = new TableColumn<>("Ações");
		Callback<TableColumn<Despesa, Void>, TableCell<Despesa, Void>> 
			acoes = new Callback<>() {
			@Override
			public TableCell<Despesa, Void> 
					call(TableColumn<Despesa, Void> param) {
				final Button btnExcluir = 
							new Button("Excluir");
				TableCell <Despesa, Void> cell = new TableCell<>(){
					{
						btnExcluir.setOnAction(event -> {
		                     Despesa data = table.getItems().get(getIndex());
	                    	 control.excluir(data);
		                 });
					}
					@Override
	                public void updateItem(Void item, boolean empty) {
	                    super.updateItem(item, empty);
	                    if (empty) {
	                        setGraphic(null);
	                    } else {
	                        setGraphic(btnExcluir);
	                    }
	                }
				};
				return cell;
			}
		};
		col4.setCellFactory(acoes);
		table.getColumns().addAll(col1, col2, col3, col4);
		table.setItems(control.getList());
		table.getSelectionModel().getSelectedItems().addListener(
				new ListChangeListener<Despesa>(){
					@Override
					public void onChanged(Change<? extends Despesa> d) {
						if (!d.getList().isEmpty()) {
							control.fromEntity(d.getList().get(0));
						}
					}
				}
		);
	}
		
	@Override
	public void start() {
		control = new DespesaControl();
		principal = new BorderPane();
		principal.setPadding(new Insets(50));
		GridPane painelForm = new GridPane();
		principal.setTop(
				new VBox(new Label("Controle de Despesas"), painelForm));
		principal.setCenter(table);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(30);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(70);
		painelForm.getColumnConstraints().addAll(col1, col2);
		
		Button btnNovo = new Button("Novo Item");
		Button btnSalvar = new Button("Salvar");
		Button btnPesquisar = new Button("Pesquisar");
		Button btnAbrirReceitas = new Button("Abrir Receitas");
		
		btnNovo.setOnAction( e -> { 
			control.novo();
		});
		
		btnSalvar.setOnAction((e)->{
			adicionar();
		});
		
		btnPesquisar.setOnAction((e)->{
			control.pesquisar();
		});
		
		btnAbrirReceitas.setOnAction((e)->{
			executor.executar("receita");
		});
			
		painelForm.add(new Label("Id"), 0, 0);
		painelForm.add(lblId, 1, 0);
		painelForm.add(new Label("Razão"), 0, 1);
		painelForm.add(txtRazao, 1, 1);
		painelForm.add(new Label("Data"), 0, 2);
		painelForm.add(txtData, 1, 2);
		painelForm.add(new Label("Valor"), 0, 3);
		painelForm.add(txtValor, 1, 3);
		
		FlowPane fpBotoes = new FlowPane();
		fpBotoes.getChildren().addAll(
				btnSalvar, btnPesquisar, btnAbrirReceitas);
		
		painelForm.add(btnNovo, 0, 4);
		painelForm.add(fpBotoes, 1, 4);

		ligacoes();
		prepararTabela();
	}
	
	public Pane render() { 
		return principal;
	}
}
