/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.incubator.ui;

import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventDispatchChain;
import javafx.scene.control.ListView;
import javafx.scene.control.Skin;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import org.cosysoft.incubator.ui.BaseControl;
import org.cosysoft.incubator.ui.skin.TableSkin;

/**
 *
 * @author Administrator
 */
public class Table extends BaseControl {

    private static final String DEFAULT_STYLE_CLASS = "table";
    public final BooleanProperty selectedProperty = new SimpleBooleanProperty(false, "SELECTED");

    public Table() {
        this.getStyleClass().add(DEFAULT_STYLE_CLASS);

        ObservableList<String> list = FXCollections.observableArrayList("AuserName", "B");
        ListView<String> listView = new ListView<>(list);

        listView.setMinSize(30, 30);

        final HBox container = new HBox(listView);

        Circle c = new Circle();
        getChildren().add(container);
        c.radiusProperty().bind(this.widthProperty().divide(2).add(-1));

        
        
        

    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new TableSkin(this);
    }



}
