package com.parking.entities;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.email = ?1")
    Customer findByEmail(String email);

    @Query("select c from Customer c where c.email = ?1 and c.password = ?2")
    Customer findByEmailAndPassword(String email, String password);
}
