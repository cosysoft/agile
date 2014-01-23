/*
 * Copyright 2014 Bluesky.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cosysoft.agile.ui;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import org.cosysoft.agile.ui.exception.AgileException;
import org.cosysoft.agile.ui.model.NavType;
import org.cosysoft.agile.ui.pane.BurndownPane;
import org.cosysoft.agile.ui.pane.ProjectPane;

/**
 *
 * @author Bluesky
 */
public class ViewManager {

    private final HashMap<NavType, Class> viewClass = new HashMap<>();

    private final HashMap<NavType, Node> viewContainer = new HashMap<>();

    public ViewManager() {
        viewClass.put(NavType.PROJECT, ProjectPane.class);
        viewClass.put(NavType.BURNDOWN, BurndownPane.class);
    }

    public Node getView(NavType key) {
        if (viewContainer.get(key) == null) {
            try {
                Class cls = viewClass.get(key);
                Node ct = (Node) cls.newInstance();
                viewContainer.put(key, ct);
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(ViewManager.class.getName()).log(Level.SEVERE, null, ex);
                throw new AgileException("error create content view", ex);
            }
        }
        return viewContainer.get(key);
    }

}
