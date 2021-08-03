package br.com.claudemirojr.oauth.services;

import br.com.claudemirojr.oauth.dto.UsuarioFullResponseDto;

public interface IUsuarioService {
	
	public UsuarioFullResponseDto findByUsername(String username);

}
