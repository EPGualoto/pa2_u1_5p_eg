package com.uce.edu.inventario.service;

import com.uce.edu.inventario.repository.modelo.Inventario;

public interface IInventarioService {
	public Inventario buscar(String codigo);

	public void guardar(Inventario inv);

	public void actualizar(Inventario inv);

	public void eliminar(String codigo);

	public void registrar(String codigoBodega, String codigoBarras, Integer stock);
}
