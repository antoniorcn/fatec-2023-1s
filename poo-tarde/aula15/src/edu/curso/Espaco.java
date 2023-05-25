package edu.curso;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Espaco extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Pane p = new Pane();
		Scene scn = new Scene(p, 800, 600);
		stage.setScene(scn);
		
//		Circle circle = new Circle(50);
//		p.getChildren().add(circle);
//		circle.relocate(200, 200);
		
		Canvas canvas = new Canvas(800, 600);
		p.getChildren().add(canvas);
		
		GraphicsContext gc2 = canvas.getGraphicsContext2D();
		Image imgEspaco = new Image(
				getClass().getResourceAsStream("/images/space.png"));
		Image imgTerra = new Image(
				getClass().getResourceAsStream("/images/earth.png"));
		Image imgMarte = new Image(
				getClass().getResourceAsStream("/images/mars.png"));	
		Image imgSol = new Image(
				getClass().getResourceAsStream("/images/sun.png"));		
		new AnimationTimer() {
			double x = 400;
			double y = 300;
			double angulo = 270;
			double anguloMarte = 270;
			double raio = 200; 
			double raioMarte = 300; 
			void drawImageCenter(GraphicsContext gc2, Image img, 
					double centerx, double centery,
					double largura, double altura) { 
				double px = centerx - largura / 2.0;
				double py = centery - altura / 2.0;
				gc2.drawImage(img, px, py, largura, altura);
			}
			@Override
			public void handle(long now) {
				// gc2.clearRect(0, 0, 800, 600);
				gc2.drawImage(imgEspaco, 0, 0, 800, 600);
				drawImageCenter(gc2, imgSol, 400, 300, 100, 100);
				double anguloRad = angulo / 180 * Math.PI;
				double anguloMarteRad = anguloMarte / 180 * Math.PI;
				double px = x + (raio/2) * Math.cos(anguloRad);
				double py = y + raio * Math.sin(anguloRad);
				double pxMarte = x + (raioMarte/2) * 
							Math.cos(anguloMarteRad);
				double pyMarte = y + raioMarte * 
							Math.sin(anguloMarteRad);
				angulo = angulo + 1;
				anguloMarte = anguloMarte + 1.5;
				drawImageCenter(gc2, imgTerra, px, py, 50, 50);
				drawImageCenter(gc2, imgMarte, pxMarte, pyMarte, 
						40, 40);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}.start();
		
		
		
		stage.setTitle("Bolinha");
		stage.show();
	}
	
	
	public static void main(String[] args) {
		Application.launch(Espaco.class, args);
	}

}
