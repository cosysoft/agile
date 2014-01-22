/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.agile.ui.pane;

import java.util.Arrays;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.cosysoft.agile.ui.event.NavItemEvent;
import org.cosysoft.agile.ui.model.NavItem;
import org.cosysoft.agile.ui.model.NavType;

/**
 *
 * @author Bluesky
 */
public class NavPane extends ListView<NavItem> {

    final List<NavItem> navs = Arrays.asList(new NavItem("Project", 5, NavType.PROJECT),
            new NavItem("BackLog", 15, NavType.BACKLOG),
            new NavItem("Task", 35, NavType.TASK),
            new NavItem("Burndown", 1, NavType.BURNDOWN));

    public NavPane() {

        this.setCellFactory(new NavItemCell());
        this.getItems().addAll(navs);

        this.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        SelectionModel sm = this.getSelectionModel();

        sm.selectedItemProperty().addListener(
                new ChangeListener<NavItem>() {
                    @Override
                    public void changed(ObservableValue<? extends NavItem> observable, NavItem oldValue, NavItem newValue) {

                        System.out.println("change" + oldValue + newValue);
                        Event.fireEvent(NavPane.this, new NavItemEvent(oldValue, newValue, NavItemEvent.NAV_CHANGED));
                    }
                });

    }

    public static class NavItemCell implements Callback<ListView<NavItem>, ListCell<NavItem>> {

        @Override
        public ListCell<NavItem> call(ListView<NavItem> param) {
            return new TextFieldListCell(new StringConverter<NavItem>() {

                @Override
                public String toString(NavItem object) {
                    return object == null ? "null" : object.getName() + " (" + object.getCount() + ")";
                }

                @Override
                public NavItem fromString(String string) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }) {

            };
        }

    }
}
