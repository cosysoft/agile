/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.incubator;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.cosysoft.incubator.ui.Space;
import org.cosysoft.incubator.ui.Table;

/**
 *
 * @author Administrator
 */
public class AjustableControl extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("可调节大小的JavaFX控件");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);

        final Space s = new Space();
        s.setPrefSize(800, 2000);

        final Table dt = new Table();

        s.getChildren().addAll(dt);
        dt.setPrefSize(300, 400);

        final ScrollPane sp = new ScrollPane();
        s.prefWidthProperty().bind(sp.widthProperty());
        sp.setContent(s);
        root.setCenter(sp);

        final Slider dtw = new Slider(.5, 10, 1);

        s.scaleXProperty().bind(dtw.valueProperty());
        s.scaleYProperty().bind(dtw.valueProperty());
        root.setTop(dtw);

        root.addEventFilter(MouseEvent.ANY, (Event event) -> {
//            event.consume();
        });
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
