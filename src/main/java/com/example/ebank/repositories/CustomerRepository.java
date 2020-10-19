package com.example.ebank.repositories;

import com.example.ebank.models.Customer;
import com.example.ebank.utils.ProfileManager;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerRepository {

    private final JpaCustomerRepository jpaRepository;
    private final MockCustomerRepository mockRepository;
    private final ProfileManager profileManager;

    public CustomerRepository(JpaCustomerRepository jpaRepository,
                              MockCustomerRepository mockRepository,
                             ProfileManager profileManager) {
        this.jpaRepository = jpaRepository;
        this.mockRepository = mockRepository;
        this.profileManager = profileManager;
    }

    public Iterable<Customer> findAll() {
        return profileManager.isMockProfileActive()
                ? mockRepository.findAll()
                : jpaRepository.findAll();
    }

    public Optional<Customer> findById(Long id) {
        return profileManager.isMockProfileActive()
                ? mockRepository.findById(id)
                : jpaRepository.findById(id);
    }
}
