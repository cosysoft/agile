/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.incubator.ui;

import org.cosysoft.incubator.ui.design.Table;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.layout.Pane;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.VLineTo;

/**
 *
 * @author Administrator
 */
public class Space extends Pane {

    private int sgap = 15;
    private Path bg;
    private List<PathElement> hpth = new ArrayList<>();
    private List<PathElement> vpth = new ArrayList<>();

    public Space() {

        bg = new Path( );
        bg.setStrokeWidth(.3);

        this.getChildren().add(bg);
        this.setOpacity(.5);
        this.setHeight(2000);

        this.widthProperty().addListener(redrawHandler);
        this.heightProperty().addListener(redrawHandler);

        this.getChildren().addListener(listChangeListener);

    }
    /**
     * 添加的组件 监听
     */
    private ListChangeListener listChangeListener = new ListChangeListener<Object>() {
        @Override
        public void onChanged(Change<? extends Object> change) {
            while (change.next()) {
                if (change.wasAdded()) {
                    System.out.println("添加事件" + change.getAddedSubList());
                    for (Object o : change.getAddedSubList()) {
                        if (o instanceof Table) {
                            System.out.println("变成可绑定的 ");
                        }
                    }
                }
            }
        }
    };
    /**
     * 背景redraw
     */
    private ChangeListener redrawHandler = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
            bg.getElements().clear();
            buildHpath();
            buildVpath();
            bg.getElements().addAll(hpth);
            bg.getElements().addAll(vpth);
            bg.getElements().add(new ClosePath());
        }
    };

    private void buildHpath() {
        vpth.clear();

        int max = (int) (this.getHeight() / sgap);
        double more = (int) this.getHeight() % sgap;
        double hgap = more / 2;
        for (int i = 0; i <= max; i++) {
            vpth.add(new MoveTo(more / 2, hgap));
            vpth.add(new HLineTo(this.getWidth()));
            hgap += sgap;
        }
    }

    private void buildVpath() {
        hpth.clear();
        int max = (int) (this.getWidth() / sgap);
        double more = (int) this.getWidth() % sgap;
        double hgap = more / 2;
        for (int i = 0; i <= max; i++) {
            hpth.add(new MoveTo(hgap, more / 2));
            hpth.add(new VLineTo(this.getHeight()));
            hgap += sgap;
        }
    }

}
