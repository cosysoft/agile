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
package org.cosysoft.scrum.service.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cosysoft.scrum.domain.Task;
import org.cosysoft.scrum.service.TaskService;

/**
 *
 * @author Bluesky
 */
public class MockTaskService implements TaskService<Task> {

    private List<Task> tasks = new ArrayList<>();

    public MockTaskService() {
        ObjectMapper om = new ObjectMapper();
        try {
            tasks = om.readValue(this.getClass().getResourceAsStream("task.json"), List.class);
        } catch (IOException ex) {
            Logger.getLogger(MockTaskService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Task e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Task e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Task e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Task> findAll() {

        return tasks;
    }

}
