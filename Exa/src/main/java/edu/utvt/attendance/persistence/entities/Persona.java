package edu.utvt.attendance.persistence.entities;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//private Long id;
	private UUID id;
	
	@Column(nullable = false, length = 50)
	private String nombre;
	
	@Column(nullable = false)
	private int edad;
	
	@Column(nullable = false, length = 100)
	private String universidad;
	
	@Column(nullable = false, length = 20)
	private String correo;
	
	@Column(nullable = false)
	private Date fechaNacimiento;
	
	//@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    //private List<Item> items;

}
