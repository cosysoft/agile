/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.agile.ui.pane;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.AnchorPane;
import org.datafx.controller.FXMLController;
import org.datafx.controller.ViewFactory;
import org.datafx.controller.context.ViewContext;
import org.datafx.controller.util.FxmlLoadException;

/**
 *
 * @author Bluesky
 */
@FXMLController("BurndownPaneView.fxml")
public class BurndownPaneView extends AnchorPane {

    private ViewContext<BurndownPaneView> vc = null;

    @FXML
    private LineChart burndownChart;

    public BurndownPaneView() {
        try {
            vc = ViewFactory.getInstance().createByController(BurndownPaneView.class);
        } catch (FxmlLoadException ex) {
            throw new RuntimeException(ex);
        }

    }

}
