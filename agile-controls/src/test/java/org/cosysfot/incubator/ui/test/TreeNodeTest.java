/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysfot.incubator.ui.test;

import org.cosysoft.incubator.ui.TreeNode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Bluesky
 */
public class TreeNodeTest {

    private TreeNode root;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        root = new TreeNode("root");
        TreeNode ch1 = new TreeNode("ch1");
        root.addChild(ch1);

        TreeNode ch2 = new TreeNode("ch2");
        TreeNode ch22 = new TreeNode("ch22");
        ch1.addChild(ch2);
        ch1.addChild(ch22);

        for (int i = 0; i < 10; i++) {
            ch22.addChild(new TreeNode("ch3" + i));
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testHeight() {
        System.out.println("hiight " + root.getHeight());

        System.out.println(root.getLevel());
        System.out.println(root.getWidth());

    }
}
