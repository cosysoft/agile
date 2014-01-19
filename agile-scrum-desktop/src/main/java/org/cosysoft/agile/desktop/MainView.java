/*
 * To change this license header, choose License Headers in Project2 Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.agile.desktop;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javax.annotation.PostConstruct;
import org.cosysoft.agile.ui.model.AgileBehavior;
import org.cosysoft.agile.ui.model.NullBehavior;
import org.cosysoft.agile.ui.model.ProjectBehavior;
import org.cosysoft.scrum.domain.Project2;
import org.datafx.controller.FXMLController;

/**
 *
 * @author Bluesky
 */
@FXMLController(value = "MainView.fxml")
public class MainView {

    @FXML
    private TreeView nav;
    @FXML
    private BorderPane master;

    private final TreeItem<AgileBehavior> root = new TreeItem(new NullBehavior());

    @PostConstruct

    public void init() {

        TreeItem<AgileBehavior> p3 = new TreeItem<>(
                new ProjectBehavior(new Project2("test2", "test")));
        TreeItem<AgileBehavior> p = new TreeItem<>(
                new ProjectBehavior(new Project2("test", "test")));
        TreeItem<AgileBehavior> p2 = new TreeItem<>(
                new ProjectBehavior(new Project2("test2", "test")));

        root.getChildren().addAll(p3, p, p2);

        nav.setCellFactory(new Callback<TreeView<AgileBehavior>, TreeCell<AgileBehavior>>() {

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

        nav.setRoot(root);

    }

    public Node swap(Node to) {

        Node old = master.getCenter();
        master.setCenter(to);
        return old;
    }
}
