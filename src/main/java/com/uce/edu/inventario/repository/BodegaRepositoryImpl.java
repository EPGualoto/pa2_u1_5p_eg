package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Bodega;

@Repository
public class BodegaRepositoryImpl implements IBodegaRepository {
	public static List<Bodega> base = new ArrayList<Bodega>();

	@Override
	public Bodega seleccionar(String codigo) {
		for (Bodega bodega : base) {
			if (bodega.getCodigo().equals(codigo)) {
				Bodega bo = new Bodega();
				bo.setCapacidad(bodega.getCapacidad());
				bo.setCodigo(bodega.getCodigo());
				bo.setDireccion(bodega.getDireccion());
				bo.setNombre(bodega.getNombre());
				return bo;
			}
		}
		return null;
	}

	public Bodega seleccionarEliminar(String codigo) {
		for (Bodega bodega : base) {
			if (bodega.equals(codigo)) {
				return bodega;
			}
		}
		return null;
	}

	@Override
	public void insertar(Bodega bodega) {
		base.add(bodega);

	}

	@Override
	public void actualizar(Bodega bodega) {
		this.eliminar(bodega.getCodigo());
		this.insertar(bodega);

	}

	@Override
	public void eliminar(String codigo) {
		Bodega bo = this.seleccionarEliminar(codigo);
		base.remove(bo);

	}

}
