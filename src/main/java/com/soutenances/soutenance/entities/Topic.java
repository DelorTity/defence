package com.soutenances.soutenance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String domain;
	private int duration;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Company company;

}
