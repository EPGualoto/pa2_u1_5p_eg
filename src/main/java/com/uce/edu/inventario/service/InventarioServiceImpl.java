package com.uce.edu.inventario.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.inventario.repository.IBodegaRepository;
import com.uce.edu.inventario.repository.IInventarioRepository;
import com.uce.edu.inventario.repository.IProductoRepository;
import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;

@Service
public class InventarioServiceImpl implements IInventarioService {
	@Autowired
	private IInventarioRepository iInventarioRepository;
	
	@Autowired
	private IBodegaRepository bodegaRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Override
	public Inventario buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.iInventarioRepository.seleccionar(codigo);
	}

	@Override
	public void guardar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.iInventarioRepository.insertar(inventario);

	}

	@Override
	public void actualizar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.iInventarioRepository.actualizar(inventario);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		this.iInventarioRepository.eliminar(codigo);
	}

	@Override
	public void registrar(String codigoBodega, String codigoBarras, Integer stock) {
		// TODO Auto-generated method stub
		Bodega bodega = this.bodegaRepository.seleccionar(codigoBodega);
		
		Producto producto = this.productoRepository.seleccionar(codigoBarras);
		Integer stockActual = producto.getStock();
		Integer stockFinal = stockActual+stock;
		producto.setStock(stockFinal);
		this.productoRepository.actualizar(producto);
		
		Inventario inv = new Inventario();
		inv.setCodigo("23423423");
		inv.setFechaIngreso(LocalDateTime.now());
		inv.setBodega(bodega);
		inv.setBodega(bodega);
		
		this.iInventarioRepository.insertar(inv);
		
		
	}

}
