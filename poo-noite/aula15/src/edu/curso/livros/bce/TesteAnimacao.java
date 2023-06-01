package edu.curso.livros.bce;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TesteAnimacao extends Application {

	
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane principal = new Pane();
		
		Scene scn = new Scene(principal, 800, 600);
		
//		Circle c1 = new Circle(50);
//		c1.relocate(100, 100);
//		principal.getChildren().add(c1);
		
		Canvas canvas = new Canvas(800, 600);
		principal.getChildren().add(canvas);
		
		GraphicsContext ct2 = canvas.getGraphicsContext2D();
		
		Image imgTerra = new Image(
				getClass().getResourceAsStream("/images/earth.png"));
		Image imgMarte = new Image(
				getClass().getResourceAsStream("/images/mars.png"));
		Image imgSol = new Image(
				getClass().getResourceAsStream("/images/sun.png"));
		Image imgEspaco = new Image(
				getClass().getResourceAsStream("/images/space.png"));
		
		new AnimationTimer() {
			
			void drawImageCenter(Image img, double cx, double cy, 
					double largura, double altura) {
				ct2.drawImage(img, cx - largura / 2, cy - altura / 2);
				
			}
			
			// double x = 0;
			double angTerra = 0;
			double raioTerra = 250;
			double angMarte = 10;
			double raioMarte = 350;
			double x = 400;
			double y = 300;
			
			
			@Override
			public void handle(long now) {
				ct2.drawImage(imgEspaco, 0, 0, 800, 600);
				// ct2.clearRect(0, 0, 800, 600);
				// ct2.fillOval(x, 100, 50, 50);
				// x = x + 10;
				angTerra = angTerra + 1;
				double angRad = angTerra / 180 * Math.PI;
				double px = x + Math.cos(angRad) * raioTerra;
				double py = y + Math.sin(angRad) * raioTerra;
				
				angMarte = angMarte + 1.5;
				double angRadMarte = angMarte / 180 * Math.PI;
				double pxMarte = x + Math.cos(angRadMarte) * raioMarte / 2;
				double pyMarte = y + Math.sin(angRadMarte) * raioMarte;
				// ct2.fillOval(px, py, 50, 50);
				drawImageCenter(imgSol, x, y, 100, 100);
				drawImageCenter(imgTerra, px, py, 50, 50);
				drawImageCenter(imgMarte, pxMarte, pyMarte, 40, 40);
			} 
			
		}.start();
		
		stage.setScene(scn);
		stage.setTitle("Teste Animação");
		stage.show();
		
	}

	
	
	public static void main(String[] args) {
		Application.launch(TesteAnimacao.class, args);
	}


}
