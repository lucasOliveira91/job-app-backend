package br.com.maisvida.jobapp.service.imp;

import br.com.maisvida.jobapp.domain.User;
import br.com.maisvida.jobapp.repository.UserRepository;
import br.com.maisvida.jobapp.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException(email);
        }

        return new UserSS(user.getId(), user.getEmail(), user.getPassword(), null);
    }
}