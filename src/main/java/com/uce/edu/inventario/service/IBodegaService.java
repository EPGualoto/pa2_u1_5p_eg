package com.uce.edu.inventario.service;

import com.uce.edu.inventario.repository.modelo.Bodega;

public interface IBodegaService {
		public Bodega buscar(String codigo);

		public void guardar(Bodega bo);

		public void actualizar(Bodega bo);

		public void eliminar(String codigo);
	}
