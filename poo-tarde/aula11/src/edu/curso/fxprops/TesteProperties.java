package edu.curso.fxprops;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

class Mobile implements ChangeListener<String> {

	@Override
	public void changed(ObservableValue<? extends String> observable,
			String oldValue, String newValue) {
		System.out.println("Mobile -- valor trocado de " + oldValue + 
						" para " + newValue);
	}
} 

class Web implements ChangeListener<String> {

	@Override
	public void changed(ObservableValue<? extends String> observable,
			String oldValue, String newValue) {
		System.out.println("Web -- valor trocado de " + oldValue + 
						" para " + newValue);
	}
}

public class TesteProperties {
	public static void main(String[] args) {
		StringProperty nome = new SimpleStringProperty("João");
		
		Mobile m1 = new Mobile();
		Web w2 = new Web();
		
		nome.addListener(m1);
		nome.addListener(w2);
		
		nome.set("Maria");
		
	}
}
