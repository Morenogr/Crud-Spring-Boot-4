package com.luis.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.luis.demo.modelo.Comprador;

public interface InterfaceVentasService {
	@Query("SELECT c FROM Comprador c WHERE c.name LIKE %?1%")
	
    List<Comprador> listar(String palabraClave);
    Optional<Comprador> listarId(int id);
    int save(Comprador comprador);
    void delete(int id);
}
