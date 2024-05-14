package com.EP2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EP2.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	void deleteById(int id);
	
}
