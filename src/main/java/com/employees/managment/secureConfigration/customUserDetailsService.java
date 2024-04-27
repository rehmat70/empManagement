package com.employees.managment.secureConfigration;

import com.employees.managment.secureRepositoryConfigration.userSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class customUserDetailsService implements UserDetailsService {
    @Autowired
private userSecurityRepository userSecurityRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserSecurity userSecurity=userSecurityRepository.findByUserName(userName);

         if (userSecurity ==null){
             throw new UsernameNotFoundException("User Not Found");
         }
        return new CustomUserDetails(userSecurity);
    }

}
