package com.cp.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name =  "users")
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;
	
	@Column(name = "user_firstname")
	private String firstName;
	
	@Column(name = "user_lastname")
	private String lastName;
	
	private Double weight;
	private Double height;
	
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Nutrition> nutrition;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Exercise> exercise;

	@OneToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "role_id")
	private Role role;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String firstName, String lastName, Double weight, Double height, String email,
			String password, List<Nutrition> nutrition, List<Exercise> exercise, Role role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.weight = weight;
		this.height = height;
		this.email = email;
		this.password = password;
		this.nutrition = nutrition;
		this.exercise = exercise;
		this.role = role;
	}


	public User(String firstName, String lastName, Double weight, Double height, String email, String password,
			Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.weight = weight;
		this.height = height;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Nutrition> getNutrition() {
		return nutrition;
	}

	public void setNutrition(List<Nutrition> nutrition) {
		this.nutrition = nutrition;
	}

	public List<Exercise> getExercise() {
		return exercise;
	}

	public void setExercise(List<Exercise> exercise) {
		this.exercise = exercise;
	}

	
	
}
