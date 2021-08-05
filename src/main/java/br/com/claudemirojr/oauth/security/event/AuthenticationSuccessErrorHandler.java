package br.com.claudemirojr.oauth.security.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import brave.Tracer;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {
	
	@Autowired
	private Tracer tracer;

	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		
		tracer.currentSpan().tag("login.sucesso", user.getUsername());
		//System.out.println("Sucesso Login: " + user.getUsername());
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		tracer.currentSpan().tag("login.error", exception.getMessage());
		//System.out.println("Error Login:" + exception.getMessage());
	}

}
