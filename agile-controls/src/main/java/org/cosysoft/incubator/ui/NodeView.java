/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.incubator.ui;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Skin;
import org.cosysoft.incubator.ui.skin.NodeViewSkin;

/**
 *
 * @author Bluesky
 */
public class NodeView extends BaseControl {

    private static final String DEFAULT_STYLE_CLASS = "node-view";
 

    public final ObjectProperty<TreeNode> rootProperty = new SimpleObjectProperty();

    public TreeNode getRoot() {
        return rootProperty.getValue();
    }

    public void setRoot(TreeNode root) {
        rootProperty.set(root);
    }

    public NodeView(TreeNode root) {
//        this.getStyleClass().add(DEFAULT_STYLE_CLASS);
        rootProperty.set(root);
    }

    public NodeView() {
        this(null);
    }

    public void refresh() {
        rebuildProperty().set(true);

    }

    private BooleanProperty rebuild;

    public final BooleanProperty rebuildProperty() {
        if (rebuild == null) {
            rebuild = new SimpleBooleanProperty(this, "rebuild", false);
        }
        return rebuild;
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new NodeViewSkin(this);
    }

}
