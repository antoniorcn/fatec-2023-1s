package edu.curso.livros.bce;

import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class AutorBoundary implements Tela {
	private TextField txtNome = new TextField();
	private TextField txtEditora = new TextField();
	private TextField txtCidade = new TextField();
	
	private AutorControl control = new AutorControl();
	private TableView<Autor> table = new TableView<>();
	
	private BorderPane principal;
	private Executor executor;

	public AutorBoundary(Executor executor) { 
		this.executor = executor;
	}
	
	public AutorBoundary() { 
		
	}
	
	public void adicionar() {
		control.adicionar();
	}
	
	public void pesquisar() { 
		control.pesquisar();
	}
	
	public void ligacoes() { 
		Bindings.bindBidirectional(txtNome.textProperty(),
				control.nomeProperty());
		Bindings.bindBidirectional(txtEditora.textProperty(), 
				control.editoraProperty());
		Bindings.bindBidirectional(txtCidade.textProperty(), 
				control.cidadeProperty());
	}
	
	public void abastecerTableView() { 
		TableColumn<Autor, String> colNome = 
					new TableColumn<>("Nome");
		colNome.setCellValueFactory(
				new PropertyValueFactory<Autor, String>("nome"));
		
		TableColumn<Autor, String> colEditora = 
				new TableColumn<>("Editora");
		colEditora.setCellValueFactory(
				new PropertyValueFactory<Autor, String>("editora"));
		
		TableColumn<Autor, String> colCidade = 
				new TableColumn<>("Cidade");
		colCidade.setCellValueFactory(
				new PropertyValueFactory<Autor, String>("cidade"));
		
		TableColumn<Autor, Void> colAcoes = 
				new TableColumn<>("Ações");
		Callback<TableColumn<Autor, Void>, TableCell<Autor, Void>>
			callBack = new Callback<>() { 
						
			@Override
			public TableCell<Autor, Void> 
					call(TableColumn<Autor, Void> col) { 				
				TableCell<Autor, Void> tCell = new TableCell<>() {
					
					final Button btnExcluir = new Button("Excluir");
					{
						btnExcluir.setOnAction( e -> {
							Autor l = table.getItems().get(getIndex());  
							control.excluir(l);
						} );
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
				return tCell;
			}			
		};
		
		colAcoes.setCellFactory(callBack);
		
		double quarto = 600.0 / 4.0;
		colNome.setPrefWidth(quarto);
		colEditora.setPrefWidth(quarto);
		colCidade.setPrefWidth(quarto);
		colAcoes.setPrefWidth(quarto);
		
		
		table.getColumns().addAll(colNome, colEditora, 
				colCidade, colAcoes);
		table.setItems( control.getLista() );
		
		table.getSelectionModel().getSelectedItems().addListener(
				new ListChangeListener<Autor>() {
					@Override
					public void onChanged(Change<? extends Autor> l) {
						if (! l.getList().isEmpty()) { 
							control.fromEntity(l.getList().get(0));
						}
					} 
				}
		);
	}
	
	@Override
	public void start() {
		principal = new BorderPane();
		
		GridPane grid = new GridPane();
		principal.setTop(grid);
		principal.setCenter(table);
		grid.add(new Label("Nome: "), 0, 0);
		grid.add(txtNome, 1, 0);
		grid.add(new Label("Editora: "), 0, 1);
		grid.add(txtEditora, 1, 1);
		grid.add(new Label("Cidade: "), 0, 2);
		grid.add(txtCidade, 1, 2);
		
		ligacoes();
		abastecerTableView();
		
		Button btnNovo = new Button("Novo");
		btnNovo.setOnAction( e -> control.novo() );
		
		Button btnSalvar = new Button("Salvar");
		btnSalvar.setOnAction(e -> adicionar());
		
		Button btnPesquisar = new Button("Pesquisar");
		btnPesquisar.setOnAction(e -> pesquisar());
		
		Button btnVerLivros = new Button("Ver Livros");
		btnVerLivros.setOnAction(e -> {
			executor.abrir("livros");
		});
		FlowPane painelBotoes = new FlowPane();
		painelBotoes.getChildren().addAll(
				btnSalvar, btnPesquisar, btnVerLivros);
		
		grid.add(btnNovo, 0, 3);
		grid.add(painelBotoes, 1, 3);
	}
	
	@Override
	public Pane render() { 
		return principal;
	}


}
