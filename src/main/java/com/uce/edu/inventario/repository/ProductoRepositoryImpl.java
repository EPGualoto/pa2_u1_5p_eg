package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Producto;

@Repository
public class ProductoRepositoryImpl implements IProductoRepository {
	public static List<Producto> base = new ArrayList<Producto>();

	@Override
	public Producto seleccionar(String codigoBarras) {
		for (Producto producto : base) {
			if (producto.getCodigoBarras().equals(codigoBarras)) {
				Producto pro = new Producto();
				pro.setCodigoBarras(producto.getCodigoBarras());
				pro.setNombre(producto.getNombre());
				pro.setStock(producto.getStock());
				return pro;
			}
		}
		return null;
	}

	public Producto seleccionarEliminar(String codigoBarras) {
		for (Producto producto : base) {
			if (producto.getCodigoBarras().equals(codigoBarras)) {
				return producto;
			}
		}
		return null;
	}

	@Override
	public void insertar(Producto pro) {
		base.add(pro);

	}

	@Override
	public void actualizar(Producto pro) {
		this.eliminar(pro.getCodigoBarras());
		this.insertar(pro);

	}

	@Override
	public void eliminar(String codigoBarras) {
		Producto pro = this.seleccionarEliminar(codigoBarras);
		base.remove(pro);

	}

}
