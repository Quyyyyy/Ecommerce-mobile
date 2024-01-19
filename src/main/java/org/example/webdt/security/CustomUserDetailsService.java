package org.example.webdt.security;

import org.example.webdt.repositories.UserEntityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserEntityRepository userRepository;

    public CustomUserDetailsService(UserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByUsernameOrEmail(username,username)
//                .map(UserRegistrationDetails::new)
//                .orElseThrow(()->new UsernameNotFoundException("Username not found"));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsernameOrEmail(username,username).orElseThrow(
                ()->new UsernameNotFoundException("Username not found")
        );
    }
}
