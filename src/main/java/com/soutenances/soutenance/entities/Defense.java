package com.soutenances.soutenance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Defense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long defenseId;
//	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDate date;

	private String time;
	private String classroom;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "student", referencedColumnName = "id")
	private User student;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "supervisor", referencedColumnName = "id")
	private User supervisor;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "jury1", referencedColumnName = "id")
	private User jury1;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "jury2", referencedColumnName = "id")
	private User jury2;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "jury3", referencedColumnName = "id")
	private User jury3;


}
