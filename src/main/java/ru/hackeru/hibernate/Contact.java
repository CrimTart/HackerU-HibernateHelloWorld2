package ru.hackeru.hibernate;

import javax.persistence.*;

/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name = "contact")
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;

	public Contact() {

	}

	public Contact(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}