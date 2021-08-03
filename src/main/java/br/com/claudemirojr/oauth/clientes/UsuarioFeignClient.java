package br.com.claudemirojr.oauth.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.claudemirojr.oauth.dto.UsuarioFullResponseDto;

@FeignClient(name = "servico-usuarios")
public interface UsuarioFeignClient {

	//@GetMapping("usuarios/search/buscar-username")
	//public Usuario findByUsername(@RequestParam String username);
	
	@GetMapping("usuario/v1/search-username/{username}")
	public UsuarioFullResponseDto findByUsername(@RequestParam String username);
	

}
