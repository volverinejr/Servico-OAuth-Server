package br.com.claudemirojr.oauth.dto;

import java.io.Serializable;
import java.util.List;

import br.com.claudemirojr.oauth.models.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioFullResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String password;

	private Boolean enabled;

	private String nome;

	private String apelido;

	private String email;
	
	private List<Role> roles;

}
