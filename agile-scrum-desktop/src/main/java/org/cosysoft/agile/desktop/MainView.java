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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javax.inject.Inject;
import org.cosysoft.agile.ui.ViewManager;
import org.cosysoft.agile.ui.event.NavItemEvent;
import org.cosysoft.agile.ui.model.AgileBehavior;
import org.cosysoft.agile.ui.model.NavItem;
import org.cosysoft.agile.ui.model.NullBehavior;
import org.cosysoft.agile.ui.model.ProjectBehavior;
import org.cosysoft.scrum.domain.Project;

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
    private BorderPane master;

    @FXML
    private SplitPane splitPane;

    @Inject
    private ViewManager viewManager;

    private final TreeItem<AgileBehavior> root = new TreeItem(new NullBehavior());

    public void initialize() {

        TreeItem<AgileBehavior> p3 = new TreeItem<>(
                new ProjectBehavior(new Project("test2", "test")));
        TreeItem<AgileBehavior> p = new TreeItem<>(
                new ProjectBehavior(new Project("test", "test")));
        TreeItem<AgileBehavior> p2 = new TreeItem<>(
                new ProjectBehavior(new Project("test2", "test")));

        root.getChildren().addAll(p3, p, p2);

        nav2.setCellFactory(new Callback<TreeView<AgileBehavior>, TreeCell<AgileBehavior>>() {

            @Override
            public TreeCell<AgileBehavior> call(TreeView<AgileBehavior> param) {
                return new TextFieldTreeCell<>(new StringConverter<AgileBehavior>() {

                    @Override
                    public String toString(AgileBehavior object) {
                        return object == null ? "null" : object.getName();
                    }

                    @Override
                    public AgileBehavior fromString(String string) {
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

    public Node swapTo(Node to) {

        Node old = master.getCenter();
        master.setCenter(to);
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

        Node p = viewManager.getView(item.getType());
        swapTo(p);
    }
}
