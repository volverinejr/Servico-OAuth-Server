package br.com.claudemirojr.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.claudemirojr.oauth.clientes.UsuarioFeignClient;
import br.com.claudemirojr.oauth.dto.UsuarioFullResponseDto;
import brave.Tracer;
import feign.FeignException;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {
	
	
	private Logger log = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioFeignClient client;
	
	@Autowired
	private Tracer tracer;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UsuarioFullResponseDto usuario = client.findByUsername(username);

			List<GrantedAuthority> authorities = usuario.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getNome())).collect(Collectors.toList());

			return new User(username, usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
		} catch (FeignException e) {
			String msgError = username + " não encontrado!";
			
			log.info(msgError);
			
			tracer.currentSpan().tag("login.error", msgError);
			
			throw new UsernameNotFoundException(msgError);
		}
	}

	@Override
	public UsuarioFullResponseDto findByUsername(String username) {
		return client.findByUsername(username);
	}

}
