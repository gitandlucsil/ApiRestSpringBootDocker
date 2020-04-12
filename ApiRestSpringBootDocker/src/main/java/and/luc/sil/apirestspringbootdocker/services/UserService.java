package and.luc.sil.apirestspringbootdocker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import and.luc.sil.apirestspringbootdocker.model.User;
import and.luc.sil.apirestspringbootdocker.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		if(user != null) {
			return user;
		}else {
			throw new UsernameNotFoundException("Username "+username+" not found!");
		}
	}

	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	
 
}
