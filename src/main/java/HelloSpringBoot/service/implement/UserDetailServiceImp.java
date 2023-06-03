package HelloSpringBoot.service.implement;

import HelloSpringBoot.domain.Authority;
import HelloSpringBoot.domain.Customer;
import HelloSpringBoot.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    private UserDetailService customerService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Customer customer = customerService.getCustomer(s);
        List<Authority> authorityList = customerService.getAuthorities(s);

        List<SimpleGrantedAuthority> list = authorityList.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(customer.getUsername(),customer.getPassword(),list);
    }
}
