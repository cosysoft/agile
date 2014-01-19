package org.cosysoft.agile.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Actor
 * 
 */
@Entity
public class Actor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	private String name;

	public Actor() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}
