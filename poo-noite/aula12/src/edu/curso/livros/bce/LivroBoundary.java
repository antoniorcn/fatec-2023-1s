package edu.curso.livros.bce;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
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
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;

public class LivroBoundary extends Application {
	private TextField txtTitulo = new TextField();
	private TextField txtPaginas = new TextField();
	private TextField txtPublicacao = new TextField();
	private DateTimeFormatter dtf = 
				DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LivroControl control = new LivroControl();
	private TableView<Livro> table = new TableView<>();

	
	public void adicionar() {
		control.adicionar();
	}
	
	public void pesquisar() { 
		control.pesquisar();
	}
	
	public void ligacoes() { 
		Bindings.bindBidirectional(txtTitulo.textProperty(),
				control.tituloProperty());
		Bindings.bindBidirectional(txtPaginas.textProperty(), 
				control.paginasProperty(), 
				(StringConverter)new IntegerStringConverter());
		Bindings.bindBidirectional(txtPublicacao.textProperty(), 
				control.publicacaoProperty(), 
				(StringConverter)new LocalDateStringConverter());
	}
	
	public void abastecerTableView() { 
		TableColumn<Livro, String> colTitulo = 
					new TableColumn<>("T�tulo");
		colTitulo.setCellValueFactory(
				new PropertyValueFactory<Livro, String>("titulo"));
		TableColumn<Livro, Integer> colPaginas = 
				new TableColumn<>("# P�ginas");
		colPaginas.setCellValueFactory(
				new PropertyValueFactory<Livro, Integer>("paginas"));
		TableColumn<Livro, String> colPublicacao = 
				new TableColumn<>("Data Publica��o");
		colPublicacao.setCellValueFactory(
				l -> new ReadOnlyStringWrapper( 
					dtf.format(l.getValue().getDataPublicacao())
				)
		);
		
		TableColumn<Livro, Void> colAcoes = 
				new TableColumn<>("A��es");
		Callback<TableColumn<Livro, Void>, TableCell<Livro, Void>>
			callBack = new Callback<>() { 
						
			@Override
			public TableCell<Livro, Void> 
					call(TableColumn<Livro, Void> col) { 				
				TableCell<Livro, Void> tCell = new TableCell<>() {
					
					final Button btnExcluir = new Button("Excluir");
					{
						btnExcluir.setOnAction( e -> {
							Livro l = table.getItems().get(getIndex());  
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
		colPublicacao.setPrefWidth(quarto);
		colPaginas.setPrefWidth(quarto);
		colTitulo.setPrefWidth(quarto);
		colAcoes.setPrefWidth(quarto);
		
		
		table.getColumns().addAll(colTitulo, colPaginas, 
				colPublicacao, colAcoes);
		table.setItems( control.getLista() );
		
		table.getSelectionModel().getSelectedItems().addListener(
				new ListChangeListener<Livro>() {
					@Override
					public void onChanged(Change<? extends Livro> l) {
						if (! l.getList().isEmpty()) { 
							control.fromEntity(l.getList().get(0));
						}
					} 
				}
		);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane principal = new BorderPane();
		Scene scn = new Scene(principal, 600, 400);
		
		GridPane grid = new GridPane();
		principal.setTop(grid);
		principal.setCenter(table);
		grid.add(new Label("Titulo: "), 0, 0);
		grid.add(txtTitulo, 1, 0);
		grid.add(new Label("#P�ginas: "), 0, 1);
		grid.add(txtPaginas, 1, 1);
		grid.add(new Label("Data de Publica��o: "), 0, 2);
		grid.add(txtPublicacao, 1, 2);
		
		ligacoes();
		abastecerTableView();
		
		Button btnNovo = new Button("Novo");
		btnNovo.setOnAction( e -> control.novo() );
		
		Button btnSalvar = new Button("Salvar");
		btnSalvar.setOnAction(e -> adicionar());
		
		Button btnPesquisar = new Button("Pesquisar");
		btnPesquisar.setOnAction(e -> pesquisar());
		
		FlowPane painelBotoes = new FlowPane();
		painelBotoes.getChildren().addAll(btnSalvar, btnPesquisar);
		
		grid.add(btnNovo, 0, 3);
		grid.add(painelBotoes, 1, 3);
		
		stage.setScene(scn);
		stage.setTitle("Gest�o de Livros");
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
