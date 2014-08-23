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
    
    private ScrollPane pane = new ScrollPane();
    
    @Override
    public void start(Stage primaryStage) {
        TreeNode tree = new TreeNode("root");
        buildRoot(tree);
        NodeView nv = new NodeView(tree);
        
        pane.setContent(nv);
        
        VBox h = new VBox();
        h.getChildren().add(pane);
        VBox.setVgrow(pane, Priority.ALWAYS);
        Button b = new Button("refresh");
        b.setOnAction(new EventHandler() {
            
            @Override
            public void handle(Event event) {
                nv.refresh();
            }
            
        });
        
        h.getChildren().add(b);
        Scene scene = new Scene(h, 400, 300);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void buildRoot(TreeNode tree) {
        TreeNode ch1 = new TreeNode("ch1");
        tree.addChild(ch1);
        
        TreeNode ch2 = new TreeNode("ch2");
        TreeNode ch22 = new TreeNode("ch22");
        ch1.addChild(ch2);
        ch1.addChild(ch22);
        
        for (int i = 0; i < 1000; i++) {
            ch22.addChild(new TreeNode("ch3" + i));
        }
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
