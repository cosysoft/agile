/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.incubator.ui.skin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javafx.beans.Observable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import org.cosysoft.incubator.ui.NodeView;
import org.cosysoft.incubator.ui.TreeNode;

/**
 *
 * @author Bluesky
 */
public class NodeViewSkin extends SkinBase<NodeView> {

    private final Pane nodePane = new Pane();

    private final Pane pathPane = new Pane();

    private boolean needRebuildNode = true;

    private double nodeWidth = 30;
    private double nodeHeight = 30;

    private double nodeHPadding = 20;
    private double nodeVPadding = 20;

    public NodeViewSkin(NodeView control) {
        super(control);

        control.rootProperty.addListener((Observable observable) -> {
            needRebuildNode = true;
            control.requestLayout();
        });

        getChildren().addAll(pathPane, nodePane);
        pathPane.toBack();
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
            pathPane.getChildren().clear();
//            buildTreeNode(root, 1, cell.getLayoutX(), cell.getLayoutY());
            buildTreeNode2(contentWidth);

        }
        needRebuildNode = false;
    }

    private Node buildCell(TreeNode root) {
        Label cell = new Label();
        Circle c = new Circle();
        c.setRadius(nodeHeight / 2);
        c.setStroke(Color.YELLOW);
        c.setFill(Color.YELLOW);

        cell.setText(root.getName());
        cell.setPrefSize(nodeWidth, nodeHeight);

        return c;
    }

    /**
     * 以父节点为参考坐标 need create root cell out of recursive method
     *
     * @param root
     * @param contentWidth
     * @param contentHeight
     * @param hierarchy
     * @param offsetSharp
     */
    private void buildTreeNode(TreeNode root, int hierarchy, double rootX, double rootY) {
        if (root == null || root.getChildren().size() < 1) {
            return;
        }
        hierarchy++;
        double childrenSize = root.getChildren().size();
        double x = rootX - childrenSize / 2 * (nodeWidth + 2 * nodeHPadding) + nodeWidth / 2;
        double y = rootY + nodeHeight + 2 * nodeVPadding;
        for (int i = 0; i < childrenSize; i++) {
            TreeNode n = root.getChildren().get(i);
            Node cell2 = buildCell(n);
            double xn = x + i * (nodeWidth + 2 * nodeVPadding) + nodeVPadding;
            cell2.setLayoutX(xn);
            cell2.setLayoutY(y);
            nodePane.getChildren().add(cell2);

            Line line = new Line(rootX, rootY, xn, y);
            pathPane.getChildren().add(line);
            buildTreeNode(n, hierarchy, xn, y);
        }

    }

    private void buildTreeNode2(double contentWidth) {
        TreeNode root = this.getSkinnable().getRoot();
        if (root == null) {
            return;
        }
        HashMap<TreeNode, Node> currentNodesMap = new HashMap<>();

        Node cell = buildCell(root);
        cell.setLayoutX(contentWidth / 2 - nodeWidth / 2);
        cell.setLayoutY(nodeVPadding);
        currentNodesMap.put(root, cell);
        nodePane.getChildren().add(cell);

        List<TreeNode> currentNodes = root.getChildren();

        List<TreeNode> nextNodes = new LinkedList<>();
        int hierarchy = 1;

        while (!currentNodes.isEmpty()) {
            hierarchy++;
            int vsize = currentNodes.size();
            double vp = contentWidth / (vsize + 1);
            for (int i = 0; i < vsize; i++) {
                TreeNode c = currentNodes.get(i);
                double xn = (i + 1) * vp - nodeWidth / 2;
                double yn = (hierarchy - 1) * nodeHeight
                        + hierarchy * 2 * nodeVPadding + nodeVPadding;
                Node cell2 = buildCell(c);
                cell2.setLayoutX(xn);
                cell2.setLayoutY(yn);
                currentNodesMap.put(c, cell2);
                nodePane.getChildren().add(cell2);

                Node p = currentNodesMap.get(c.getParent());
                Line l = new Line(p.getLayoutX(),
                        p.getLayoutY(),
                        cell2.getLayoutX(),
                        cell2.getLayoutY());
                pathPane.getChildren().add(l);
            }
            nextNodes.clear();

            for (TreeNode n : currentNodes) {
                nextNodes.addAll(n.getChildren());
            }
            currentNodes = new ArrayList<>(nextNodes);
        }
    }

    @Override
    protected double computeMinHeight(double width, double topInset, double rightInset, double bottomInset, double leftInset) {
        double minHeight = super.computeMinHeight(width, topInset, rightInset, bottomInset, leftInset);
        return getSkinnable().getRoot().getHeight() * (nodeHeight + 2 * nodeVPadding)+minHeight;
    }

    @Override
    protected double computeMinWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
        double minWidth = super.computeMinWidth(height, topInset, rightInset, bottomInset, leftInset);
        return getSkinnable().getRoot().getWidth() * (nodeWidth + 2 * nodeHPadding);
    }

}
