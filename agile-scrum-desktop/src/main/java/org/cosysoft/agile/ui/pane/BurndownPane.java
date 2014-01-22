/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.agile.ui.pane;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Bluesky
 */
public class BurndownPane extends AnchorPane {

    @FXML
    private LineChart burndownChart;
    
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    
    public BurndownPane() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "BurndownPaneView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    public void initialize() {
        xAxis = new NumberAxis("Values for X-Axis", 0, 14, 1);
        yAxis = new NumberAxis("Values for Y-Axis", 0, 14, 1);
        ObservableList<XYChart.Series<Double,Double>> lineChartData = FXCollections.observableArrayList(
            new LineChart.Series<>("Series 1", FXCollections.observableArrayList(
                new XYChart.Data<>(0.0, 1.0),
                new XYChart.Data<>(1.2, 1.4),
                new XYChart.Data<>(2.2, 1.9),
                new XYChart.Data<>(2.7, 2.3),
                new XYChart.Data<>(2.9, 0.5)
            )),
            new LineChart.Series<>("Series 2", FXCollections.observableArrayList(
                new XYChart.Data<>(0.0, 1.6),
                new XYChart.Data<>(0.8, 0.4),
                new XYChart.Data<>(1.4, 2.9),
                new XYChart.Data<>(2.1, 1.3),
                new XYChart.Data<>(2.6, 0.9)
            ))
        );
        burndownChart.setData(lineChartData);
        
        System.out.println("postconstruct"+this.getClass());
    }
}
