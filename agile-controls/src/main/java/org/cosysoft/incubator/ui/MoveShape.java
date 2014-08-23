/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.incubator.ui;

import org.cosysoft.incubator.ui.BaseControl;
import org.cosysoft.incubator.ui.skin.MoveShapeSkin;

/**
 *
 * @author Administrator
 */
public class MoveShape extends BaseControl {

    private static final String DEFAULT_STYLE_CLASS = "move";

    public MoveShape() {
        this.getStyleClass().add(DEFAULT_STYLE_CLASS);
        this.setPrefSize(20, 20);
        this.setSkin(new MoveShapeSkin(this));

    }

}
