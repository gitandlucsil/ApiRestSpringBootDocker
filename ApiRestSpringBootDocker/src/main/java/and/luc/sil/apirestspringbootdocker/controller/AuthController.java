package and.luc.sil.apirestspringbootdocker.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import and.luc.sil.apirestspringbootdocker.model.User;
import and.luc.sil.apirestspringbootdocker.repository.UserRepository;
import and.luc.sil.apirestspringbootdocker.security.AccountCredentialsVO;
import and.luc.sil.apirestspringbootdocker.security.jwt.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtTokenProvider tokenProvider;
	@Autowired
	UserRepository repository;
	 
	@PostMapping(value = "/signin", produces = {"application/json","application/xml","application/x-yaml"},consumes = {"application/json","application/xml","application/x-yaml"})
	@SuppressWarnings("rawtypes")
	public ResponseEntity create(@RequestBody AccountCredentialsVO data) {
		String username = data.getUsername();
		String password = data.getPassword();
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		User user = repository.findByUsername(username);
		String token = "";
		if(user != null) {
			token = tokenProvider.createToken(username, user.getRoles());
		}else {
			throw new UsernameNotFoundException("Username "+username+" not found!");
		}
		Map<Object,Object> model = new HashMap<>();
		model.put("username", username);
		model.put("token", token);
		return ok(model);
	}
}
