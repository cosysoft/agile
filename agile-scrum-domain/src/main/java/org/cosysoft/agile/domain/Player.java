package org.cosysoft.agile.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Player
 * 
 */
@Entity
@XmlRootElement
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@Column
	private String name;

	public Player() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "User [id=" + id + ", name=" + name + "]";
	}

}
