package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Inventario;

@Repository
public class InventarioRepositoryImpl implements IInventarioRepository {
	 
	public static List<Inventario> base = new ArrayList<Inventario>();
 
	@Override
	public Inventario seleccionar(String codigo) {
		for (Inventario inventario : base) {
			if (inventario.getCodigo().equals(codigo)) {
				Inventario inv = new Inventario();
				inv.setBodega(inventario.getBodega());
				inv.setCodigo(inventario.getCodigo());
				inv.setFechaIngreso(inventario.getFechaIngreso());
				inv.setProducto(inventario.getProducto());
				return inv;
			}
		}
		return null;
	}
 
	public Inventario seleccionarEliminar(String codigo) {
		for (Inventario inv : base) {
			if (inv.getCodigo().equals(codigo)) {
				return inv;
			}
		}
		return null;
	}
 
	@Override
	public void insertar(Inventario inv) {
		base.add(inv);
 
	}
 
	@Override
	public void actualizar(Inventario inv) {
		this.eliminar(inv.getCodigo());
		this.insertar(inv);
 
	}
 
	@Override
	public void eliminar(String codigo) {
		Inventario i = this.seleccionarEliminar(codigo);
		base.remove(i);
 
	}
 
}