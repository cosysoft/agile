package org.cosysoft.agile.desktop;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.cosysoft.agile.ui.pane.ProjectPane;
import org.datafx.controller.ViewFactory;
import org.datafx.controller.context.FXMLViewContext;
import org.datafx.controller.context.ViewContext;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        ProjectPane p =new ProjectPane();
        
        ViewContext<MainView> mainView =ViewFactory.getInstance().createByController(MainView.class);

        Scene scene = new Scene((Parent) mainView.getRootNode());
        scene.getStylesheets().add("/styles/Styles.css");
        
        mainView.getController().swap(p);

        stage.setOnCloseRequest((WindowEvent event) -> {
            System.exit(0);
        });
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
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
