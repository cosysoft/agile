/*
 * To change this license header, choose License Headers in Project2 Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project2 Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project2 Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project2 Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package org.cosysoft.agile.desktop;

import com.cathive.fx.guice.FXMLController;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javax.inject.Inject;
import org.cosysoft.agile.ui.ViewManager;
import org.cosysoft.agile.ui.event.NavItemEvent;
import org.cosysoft.agile.ui.model.NavItem;

/**
 *
 * @author Bluesky
 */
@FXMLController
public class MainView {

    @FXML
    private VBox rootGroup;
    @FXML
    private TreeView nav2;
    @FXML
    private Pane master;

    @FXML
    private SplitPane splitPane;

    @Inject
    private ViewManager viewManager;

    private final TreeItem<NavItem> root = new TreeItem(NavItem.EMPTY);

    public void initialize() {
        NavItem.navs.stream().forEach((ni) -> {
            root.getChildren().add(new TreeItem<>(ni));
        });

        nav2.setCellFactory(new Callback<TreeView<NavItem>, TreeCell<NavItem>>() {

            @Override
            public TreeCell<NavItem> call(TreeView<NavItem> param) {
                return new TextFieldTreeCell<>(new StringConverter<NavItem>() {

                    @Override
                    public String toString(NavItem object) {
                        return object == null ? "null" : object.getName();
                    }

                    @Override
                    public NavItem fromString(String string) {
                        throw new UnsupportedOperationException();
                    }
                });
            }
        });

        nav2.setRoot(root);

        rootGroup.addEventHandler(NavItemEvent.NAV_CHANGED, new EventHandler<NavItemEvent>() {

            @Override
            public void handle(NavItemEvent event) {
                NavItem newItem = event.getNewValue();
                swithBy(newItem);
            }

        });

        splitPane.getStyleClass().add("hidden-splitter");

    }

    public Node swapTo(Region to) {
        Region old = (Region) master.getChildren().get(0);

        swipe2Right(to, old);
//        master.setCenter(to);
//        WritableImage image = to.snapshot(new SnapshotParameters(), null);
//       
//        try {
//            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", new File("nn.png"));
//        } catch (IOException ex) {
//            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return old;
    }

   

    public void swithBy(NavItem item) {
//        switch (item.getType()) {
//            case PROJECT: {
//                swapTo(projectPane);
//                break;
//            }
//            case BURNDOWN:
//                swapTo(burndownPane);
//                break;
//        }

        Region p = viewManager.getView(item.getType());
        swapTo(p);
    }
    
     private void swipe2Right(Region to, Region old) {
        to.setTranslateX(0);
        to.setTranslateY(0);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(400), old);

        translateTransition.setFromX(old.getLayoutX());
        translateTransition.setToX(master.getLayoutBounds().getWidth());
        translateTransition.setInterpolator(Interpolator.EASE_OUT);
        translateTransition.setCycleCount(1);
        translateTransition.play();

        translateTransition.setOnFinished(new EventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println("master p" + master.getParent());
                master.getChildren().clear();
                master.getChildren().add(to);
                to.prefWidthProperty().bind(master.prefWidthProperty());
//                LayoutUtils.fix2Parent(to, master);
//                to.prefWidthProperty().bind(master.prefWidthProperty());

            }

        });
    }
}
