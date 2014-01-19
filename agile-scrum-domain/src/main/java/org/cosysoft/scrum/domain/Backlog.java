/*
 * Copyright 2013 Bluesky.
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
package org.cosysoft.scrum.domain;

import org.cosysoft.agile.domain.dict.Priority;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Bluesky
 */
@Entity
public class Backlog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer backlogId;
    @Column
    private String name;
    @Column
    private String userStory;
    @Column
    private String type;

    @Column
    private Priority priority = Priority.MIDDLE;

    public Integer getBacklogId() {
        return backlogId;
    }

    public void setBacklogId(Integer backlogId) {
        this.backlogId = backlogId;
    }

    public String getUserStory() {
        return userStory;
    }

    public void setUserStory(String userStory) {
        this.userStory = userStory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.backlogId);
        hash = 83 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Backlog other = (Backlog) obj;
        return Objects.equals(this.backlogId, other.backlogId);
    }

    @Override
    public String toString() {
        return "Backlog{" + "backlogId=" + backlogId + ", name=" + name + ", userStory=" + userStory + ", type=" + type + ", priority=" + priority + '}';
    }

}
