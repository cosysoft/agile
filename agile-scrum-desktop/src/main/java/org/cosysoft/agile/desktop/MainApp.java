package org.cosysoft.agile.desktop;

import com.cathive.fx.guice.GuiceApplication;
import com.cathive.fx.guice.GuiceFXMLLoader;
import com.cathive.fx.guice.GuiceFXMLLoader.Result;
import com.google.inject.Module;
import java.util.List;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.inject.Inject;

public class MainApp extends GuiceApplication {

    @Inject
    private GuiceFXMLLoader fxmlLoader;

    @Override
    public void start(Stage stage) throws Exception {

        Result rs = fxmlLoader.load(getClass().getResource("MainView.fxml"));
        final Parent root = rs.getRoot();

        Scene scene = new Scene(root);

        MainView mv = rs.getController();
       
        stage.setOnCloseRequest((WindowEvent event) -> {
            System.exit(0);
        });
         scene.getStylesheets().add("/styles/Styles.css");
        stage.getIcons().add(new Image("/styles/logo.png"));
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

    @Override
    public void init(List<Module> modules) throws Exception {

    }

}
