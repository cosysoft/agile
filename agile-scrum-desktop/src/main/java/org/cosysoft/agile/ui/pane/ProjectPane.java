/*
 * To change this license header, choose License Headers in Project2 Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.agile.ui.pane;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;
import org.cosysoft.scrum.domain.Project2;
import org.datafx.controller.ViewFactory;
import org.datafx.controller.context.ViewContext;
import org.datafx.controller.util.FxmlLoadException;

/**
 *
 * @author Bluesky
 */
public class ProjectPane extends GridView<Project2> {

    public ProjectPane() {

        this.setCellFactory((GridView<Project2> param) -> {
            return new PrjectGridCell();
        });
        this.setCellHeight(200);
        this.setCellWidth(300);
        initProjects();

    }

    private void initProjects() {
        Project2 p = new Project2();
        p.setAbout("daksdj看电视减肥烧烤的房价kdsjf");
        
        
        p.setName("MCS");
        Project2 p2 = new Project2();
        p2.setName("掌上医院");
        p2.setAbout("daksdj看电视sdfffffffffffffffff"
                + "dfffffffffffffffff减肥烧烤的房价kdsjf");
        Project2 p3 = new Project2();
        p3.setName("掌上医院");
        p3.setAbout("daksdj看电视sdfffffffffff"
                + "ffffffdfffffffffffffffff减肥烧烤的房价kdsjf");
        Project2 p4 = new Project2();
        p4.setName("掌上医院");
        p4.setAbout("daksdj看电视sdfffffffffffsdfffffffffffffffffffff"
                + "ffffffdfffffffffffffffff减肥烧烤的房价kdsjf");

        getItems().addAll(p, p2, p3, p4);
    }

//    public ProjectPane(ObservableList<Project> items) {
//        super(items);
//    }
    public static class PrjectGridCell extends GridCell<Project2> {

        ViewContext<ProjectItemView> vc = null;

        public PrjectGridCell() {

            try {
                vc = ViewFactory.getInstance().createByController(ProjectItemView.class);
            } catch (FxmlLoadException ex) {
                Logger.getLogger(ProjectPane.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException(ex);
            }

            setGraphic(vc.getRootNode());

        }

        @Override
        protected void updateItem(Project2 item, boolean empty) {
            super.updateItem(item, empty);
            getChildren().clear();

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                vc.getController().setProject(item);
                setGraphic(vc.getRootNode());
            }
        }

    }
}
