/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.incubator.ui.skin;

import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.Pane;
import org.cosysoft.incubator.ui.NodeView;
import org.cosysoft.incubator.ui.TreeNode;

/**
 *
 * @author Bluesky
 */
public class NodeViewSkin extends SkinBase<NodeView> {

    private final Pane nodePane = new Pane();

    private boolean needRebuildNode = true;

    public NodeViewSkin(NodeView control) {
        super(control);

        control.rebuildProperty().addListener((Observable observable) -> {
            needRebuildNode = true;
            control.requestLayout();
        });
    }

    @Override
    protected void layoutChildren(double contentX, double contentY, double contentWidth, double contentHeight) {
        super.layoutChildren(contentX, contentY, contentWidth, contentHeight);

        buildTreeNode(contentWidth, contentHeight);

    }

    private void buildTreeNode(double contentWidth, double contentHeight) {
        if (needRebuildNode) {
            System.out.println("rebuld cells");
            nodePane.getChildren().clear();
            buildTreeNode(getSkinnable().getRoot(), contentWidth, contentHeight, 1, contentWidth / 2);
            getChildren().clear();
            getChildren().addAll(nodePane);
        }
        needRebuildNode = false;
    }

    /**
     * 以父节点为参考坐标
     *
     * @param root
     * @param contentWidth
     * @param contentHeight
     * @param vsize
     * @param offsetSharp
     */
    private void buildTreeNode(TreeNode root, double contentWidth, double contentHeight, int vsize, double offsetSharp) {
        if (root == null) {
            return;
        }
        Label cell = new Label();
        cell.setText(root.getName());
        cell.setPrefSize(80, 20);

        TreeNode parent = root.getParent();
        int hsize = parent == null ? 1 : parent.getChildren().size();
        int hindex = parent == null ? 0 : parent.getChildren().indexOf(root);

        cell.setLayoutX(offsetSharp + contentWidth / (hsize + 1) * hindex);
        cell.setLayoutY((vsize - 1) * 60);
        nodePane.getChildren().add(cell);

        vsize++;
        for (TreeNode n : root.getChildren()) {
//            off
            buildTreeNode(n, contentWidth, contentHeight, vsize, offsetSharp);
        }

    }

    @Override
    protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        double minHeight = super.computeMinHeight(width, topInset, rightInset, bottomInset, leftInset);
        return getSkinnable().getRoot().getHeight() * (20 + 60);
    }

    @Override
    protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        double minWidth = super.computeMinWidth(height, topInset, rightInset, bottomInset, leftInset);
        return getSkinnable().getRoot().getWidth() * (80);
    }

}
