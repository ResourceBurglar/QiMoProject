package HelloSpringBoot.service;

import HelloSpringBoot.domain.Authority;
import HelloSpringBoot.domain.Customer;
import HelloSpringBoot.repository.AuthorityRepository;
import HelloSpringBoot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer getCustomer(String username){
       return customerRepository.findByUsername(username);
    }

    @Autowired
    private AuthorityRepository authorityRepository;
    public List<Authority> getAuthorities(String username){
        return authorityRepository.findAuthoritiesByUsername(username);
    }

}
