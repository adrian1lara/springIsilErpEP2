package com.EP2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EP2.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
