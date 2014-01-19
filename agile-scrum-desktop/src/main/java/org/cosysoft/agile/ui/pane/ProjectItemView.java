/*
 * To change this license header, choose License Headers in Project2 Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.agile.ui.pane;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import org.cosysoft.scrum.domain.Project2;
import org.datafx.controller.FXMLController;

/**
 *
 * @author Bluesky
 */
@FXMLController(value = "ProjectItemView.fxml")
public class ProjectItemView {

    private Project2 project;

    @FXML
    private Label name;
    @FXML
    private Text desc;

    public ProjectItemView() {

    }

    public void setProject(Project2 p) {
        this.project = p;
        if (this.project != null) {
            this.name.setText(p.getName());
            this.desc.setText(p.getAbout());
        }
    }

    public void init() {

    }
}
