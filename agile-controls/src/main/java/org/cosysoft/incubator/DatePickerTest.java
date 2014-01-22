/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.incubator;

import com.cathive.fonts.fontawesome.FontAwesomeIcon;
import com.cathive.fonts.fontawesome.FontAwesomeIconView;
import java.awt.Color;
import java.awt.Transparency;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Bluesky
 */
public class DatePickerTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        FontAwesomeIconView icon = new FontAwesomeIconView();
        icon.setStyle("-fx-text-fill: rgb(155,122,12)");
        icon.setIcon(FontAwesomeIcon.ICON_ANDROID);
        btn.setGraphic(icon);
        StackPane root = new StackPane();

        Font f = Font.font(40);
        btn.setFont(f);
        icon.setFont(f);
        btn.setStyle(" -fx-text-fill: rgb(255,0,0)");
        root.getChildren().addAll(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
