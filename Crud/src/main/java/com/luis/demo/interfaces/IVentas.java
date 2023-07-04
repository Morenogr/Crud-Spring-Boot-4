package com.luis.demo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.luis.demo.modelo.Comprador;

public interface IVentas extends CrudRepository<Comprador, Integer> {
	@Query("SELECT c FROM Comprador c WHERE " + " CONCAT(c.id, c.name, c.telefono, c.precio, c.opciones, c.fecha)"
			+ " LIKE %?1%")
	public List<Comprador> findAll(String palabraClave);
}
