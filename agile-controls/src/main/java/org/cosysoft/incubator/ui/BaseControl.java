/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.incubator.ui;

import javafx.scene.control.Control;

/**
 *
 * @author Bluesky
 */
public class BaseControl extends Control {

    @Override
    protected String getUserAgentStylesheet() {
        return BaseControl.class.getResource("design.css").toExternalForm();
    }
}
