/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.agile.ui.pane;

import com.cathive.fx.guice.FXMLComponent;
import javax.inject.Inject;
import org.controlsfx.control.GridCell;
import org.cosysoft.scrum.domain.Project;

/**
 *
 * @author Bluesky
 */
public class ProjectGridCell extends GridCell<Project> {

    ProjectItemView piv;

    public ProjectGridCell() {
        piv = new ProjectItemView();
    }

    @Override
    protected void updateItem(Project item, boolean empty) {
        super.updateItem(item, empty);
        getChildren().clear();
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            piv.setProject(item);
            setGraphic(piv.getRootPane());
        }
    }

}
