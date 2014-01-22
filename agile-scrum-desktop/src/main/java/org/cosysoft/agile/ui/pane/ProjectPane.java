package org.cosysoft.agile.ui.pane;

import org.controlsfx.control.GridView;
import org.cosysoft.scrum.domain.Project;

/**
 *
 * @author Bluesky
 */
public class ProjectPane extends GridView<Project> {

    public ProjectPane() {
        this.setCellFactory((GridView<Project> param) -> new ProjectGridCell());
        this.setCellHeight(200);
        this.setCellWidth(300);
        initProjects();

    }

    private void initProjects() {
        Project p = new Project();
        p.setAbout("daksdj看电视减肥烧烤的房价kdsjf");

        p.setName("MCS");
        Project p2 = new Project();
        p2.setName("掌上医院");
        p2.setAbout("daksdj看电视sdfffffffffffffffff"
                + "dfffffffffffffffff减肥烧烤的房价kdsjf");
        Project p3 = new Project();
        p3.setName("掌上医院");
        p3.setAbout("daksdj看电视sdfffffffffff"
                + "ffffffdfffffffffffffffff减肥烧烤的房价kdsjf");
        Project p4 = new Project();
        p4.setName("掌上医院");
        p4.setAbout("daksdj看电视sdfffffffffffsdfffffffffffffffffffff"
                + "ffffffdfffffffffffffffff减肥烧烤的房价kdsjf");

        getItems().addAll(p, p2, p3, p4);
    }

}
