/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysfot.incubator.ui.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bluesky
 */
public class PerformanceTest {

    public PerformanceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void for1() {
        long l = 0;
        for (int i = 0; i < 10000 * 10000 * 10000; i++) {
            l += i;
        }
    }

    @Test
    public void for2() {
        for (int i = 0; i < 10000 * 10000 * 10000; i++) {

        }
    }
}
