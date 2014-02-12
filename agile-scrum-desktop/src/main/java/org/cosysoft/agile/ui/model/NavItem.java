/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.agile.ui.model;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bluesky
 */
public class NavItem {

    public static final NavItem EMPTY = new NavItem("Root", 35, NavType.EMPTY);

    public static final List<NavItem> navs = Arrays.asList(new NavItem("Project", 5, NavType.PROJECT),
            new NavItem("BackLog", 15, NavType.BACKLOG),
            new NavItem("Task", 35, NavType.TASK),
            new NavItem("Burndown", 1, NavType.BURNDOWN));

    private String name;
    private Integer count;
    private NavType type;

    public NavItem() {
    }

    public NavItem(String name, int count, NavType type) {
        this.name = name;
        this.count = count;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public NavType getType() {
        return type;
    }

    public void setType(NavType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NavItem{" + "name=" + name + ", count=" + count + ", type=" + type + '}';
    }

}
