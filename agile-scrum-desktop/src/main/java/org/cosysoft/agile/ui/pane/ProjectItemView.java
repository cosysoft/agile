/*
 * To change this license header, choose License Headers in Project2 Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project2 Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cosysoft.agile.ui.pane;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.cosysoft.scrum.domain.Project;

/**
 *
 * @author Bluesky
 */
public class ProjectItemView extends VBox {

    private Project project;

    @FXML
    private VBox rootPane;
    @FXML
    private Label name;
    @FXML
    private Text desc;

    public ProjectItemView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "ProjectItemView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setProject(Project p) {
        this.project = p;
        if (this.project != null) {
            this.name.setText(p.getName());
            this.desc.setText(p.getAbout());
        }
    }

//        }
//    }
    public VBox getRootPane() {
        return rootPane;
    }

}
