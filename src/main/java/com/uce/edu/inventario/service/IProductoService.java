package com.uce.edu.inventario.service;

import com.uce.edu.inventario.repository.modelo.Producto;

public interface IProductoService {
		public Producto buscar(String codigoBarras);

		public void guardar(Producto pro);

		public void actualizar(Producto pro);

		public void eliminar(String codigoBarras);
	}

