package edu.curso;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TelaBolinha extends Application {

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
		
		new AnimationTimer() {
			double x = 0;
			double velX = 10;
			
			@Override
			public void handle(long now) {
				gc2.clearRect(0, 0, 800, 600);
				gc2.fillOval(x, 0, 50, 50);
				x = x + velX;
				if ( x > 800 - 50 ) {
					velX = -10;
				}
				if (x < 0) { 
					velX = 10;
				}
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
		Application.launch(TelaBolinha.class, args);
	}

}
