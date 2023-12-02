package com.uce.edu.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.inventario.repository.IBodegaRepository;
import com.uce.edu.inventario.repository.modelo.Bodega;

@Service
public class BodegaServiceImpl implements IBodegaService {
	@Autowired
	private IBodegaRepository iBodegaRepository;

	@Override
	public Bodega buscar(String codigo) {
		return this.iBodegaRepository.seleccionar(codigo);
	}

	@Override
	public void guardar(Bodega bo) {
		this.iBodegaRepository.insertar(bo);
	}

	@Override
	public void actualizar(Bodega bo) {
		this.iBodegaRepository.actualizar(bo);

	}

	@Override
	public void eliminar(String codigo) {
		this.iBodegaRepository.eliminar(codigo);

	}

}