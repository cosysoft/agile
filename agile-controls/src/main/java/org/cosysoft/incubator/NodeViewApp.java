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

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ObservableNumberValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.cosysoft.incubator.ui.NodeView;
import org.cosysoft.incubator.ui.TreeNode;

/**
 *
 * @author Bluesky
 */
public class NodeViewApp extends Application {

    private final ScrollPane pane = new ScrollPane();
    private ObservableNumberValue Observable;

    @Override
    public void start(Stage primaryStage) {
        TreeNode tree = TreeNode.randomTree();
        NodeView nv = new NodeView(tree);
        pane.setContent(nv);
        VBox h = new VBox();
        VBox.setVgrow(pane, Priority.ALWAYS);
        Button b = new Button("Random Tree");
        primaryStage.widthProperty().addListener((Observable observable) -> {
            b.setPrefWidth(primaryStage.getWidth());
        });
        b.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                TreeNode t = TreeNode.randomTree();
                nv.rootProperty.set(t);
            }

        });

        h.getChildren().addAll(b, pane);
        Scene scene = new Scene(h, 400, 300);
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
