/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.agile.ui.event;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import org.cosysoft.agile.ui.model.NavItem;

/**
 *
 * @author Bluesky
 */
public class NavItemEvent extends Event {

    public static final EventType<NavItemEvent> NAV_CHANGED
            = new EventType<>(NavItemEvent.ANY, "NAV_CHANGED");

    private NavItem oldValue;
    private NavItem newValue;

    public NavItemEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public NavItemEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }

    public NavItemEvent(NavItem oldValue, NavItem newValue, EventType<? extends Event> eventType) {
        super(eventType);
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public String toString() {
        return "NavItemEvent{" + "oldValue=" + oldValue + ", newValue=" + newValue + '}';
    }

    public NavItem getOldValue() {
        return oldValue;
    }

    public NavItem getNewValue() {
        return newValue;
    }


}
