package br.com.claudemirojr.oauth.models.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@Column(length = 100, unique = true)
	private String nome;

}
