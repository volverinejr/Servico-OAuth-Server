package br.com.claudemirojr.oauth.models.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@Column(length = 20, unique = true)
	private String username;

	//@Column(length = 100)
	private String password;

	private Boolean enabled;

	//@Column(length = 100)
	private String nome;

	//@Column(length = 20)
	private String apelido;

	//@Column(length = 100, unique = true)
	private String email;

	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_role", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "usuario_id", "role_id" }) })*/
	private List<Role> roles;

}
