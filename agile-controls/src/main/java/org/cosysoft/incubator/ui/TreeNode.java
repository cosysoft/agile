/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.incubator.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javafx.scene.Node;

/**
 *
 * @author Bluesky
 */
public class TreeNode {

    private String name;

    private TreeNode parent;

    private Node graphic = null;

    private List<TreeNode> children;

    public TreeNode(String name) {
        this.name = name;
    }

    public int getLevel() {
        int level = 1;
        TreeNode p = this.getParent();
        while (p != null) {
            level++;
            p = p.getParent();
        }
        return level;
    }

    public int getHeight() {
        return getHeight(this);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.getChildren().isEmpty()) {
            return 1;
        } else {
            int[] rs = new int[node.getChildren().size()];
            for (int i = 0; i < rs.length; i++) {
                rs[i] = getHeight(node.getChildren().get(i));
            }
            Arrays.sort(rs);
            return rs[node.getChildren().size() - 1] + 1;
        }
    }

    public int getWidth() {
        return getWidth(this);
    }

    private int getWidth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        List<TreeNode> currentNodes = node.getChildren();
        int maxWidth = 1;
        List<TreeNode> nextNodes = new LinkedList<>();
        while (!currentNodes.isEmpty()) {
            int width = 0;
            nextNodes.clear();
            for (TreeNode n : currentNodes) {
                width += n.getChildren().size();
                nextNodes.addAll(n.getChildren());
            }
            currentNodes = new ArrayList<>(nextNodes);
            if (maxWidth < width) {
                maxWidth = width;
            }
        }
        return maxWidth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public Node getGraphic() {
        return graphic;
    }

    public void setGraphic(Node graphic) {
        this.graphic = graphic;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        if (children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

    public boolean addChild(TreeNode child) {
        child.setParent(this);
        return this.getChildren().add(child);
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public static TreeNode randomTree() {
        TreeNode root = new TreeNode("root");
        randomTree(root);
        return root;
    }

    private static void randomTree(TreeNode root) {
        if (root.getLevel() > 8) {
            return;
        }
        int level = 1;
        Random r = new Random();
        int l = r.nextInt(4);
        if (l > 0) {
            for (int i = 0; i < l; i++) {
                root.addChild(new TreeNode(root.getName() + level));
            }
        }
        level++;
        for (TreeNode c : root.getChildren()) {
            randomTree(c);
        }
    }
}
