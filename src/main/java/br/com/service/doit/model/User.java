package br.com.service.doit.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

/**
 * The persistent class for the users database table.
 * ESSE MODEL E PARA O H2
 *
 *
 */
@Data
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column
	private String email;

	@Column
	private String name;

	@Column
	private String password;

	@Column(name = "created_at")
	private Timestamp createdAt;

}