package com.luis.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luis.demo.interfaceService.InterfaceVentasService;
import com.luis.demo.interfaces.IVentas;
import com.luis.demo.modelo.Comprador;

@Service
public class CompradorService implements InterfaceVentasService{
	
	@Autowired
	private IVentas data;
	
	@Override
	public List<Comprador> listar(String palabraClave){
		if(palabraClave != null) {
			return data.findAll(palabraClave);
		}
		return (List<Comprador>)data.findAll();
	}

	@Override
	public Optional<Comprador> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Comprador p) {
		int res=0;
		Comprador comprador=data.save(p);
		if(!comprador.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}
	

}
