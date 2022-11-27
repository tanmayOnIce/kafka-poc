package in.co.indusnet.kafkademo.service.impl;

import in.co.indusnet.kafkademo.entity.TokenUserDetails;
import in.co.indusnet.kafkademo.entity.Users;
import in.co.indusnet.kafkademo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepository.findByEmail(username);

        return new TokenUserDetails(user);
    }
}
