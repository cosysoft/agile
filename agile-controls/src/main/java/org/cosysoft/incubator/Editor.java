/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.incubator;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 */
public class Editor extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		
		final BooleanProperty flag = new SimpleBooleanProperty(true);

		primaryStage.setTitle("Hello World");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 800, 600);

		final HTMLEditor editor = new HTMLEditor();
		
		
		editor.setPrefHeight(300);
	
		root.setCenter(editor);
		final Text tf = new Text();
		tf.setText(editor.getHtmlText());
		root.setBottom(tf);
	

		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
