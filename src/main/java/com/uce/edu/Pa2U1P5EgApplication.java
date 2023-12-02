package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;

@SpringBootApplication
public class Pa2U1P5EgApplication implements CommandLineRunner {
	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IBodegaService iBodegaService;
	
	@Autowired
	private IInventarioService iInventariService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5EgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//1. Crear dos produtos:
		Producto p1= new Producto();
		p1.setCodigoBarras("123456");
		p1.setNombre("HP 15 laptop");
		p1.setStock(0);
		this.iProductoService.guardar(p1);
		
		Producto p2= new Producto();
		p2.setCodigoBarras("46456456");
		p2.setNombre("Teclado HP");
		p2.setStock(0);
		this.iProductoService.guardar(p2);
		
		//2. Crear una bodega:
		Bodega b1= new Bodega();
		b1.setCapacidad(200);
		b1.setCodigo("252525");
		b1.setDireccion("El inca");
		b1.setNombre("AKI");
		this.iBodegaService.guardar(b1);
		System.out.println(b1);
		
		//3.Registrar inventario:
		Inventario i= new Inventario();
		i.setBodega(b1);
		i.setCodigo("252525");
		i.setProducto(p2);
		i.setProducto(p1);
		i.setFechaIngreso(LocalDateTime.now());
		this.iInventariService.registrar("252525", "123456", 50);
	
		this.iInventariService.registrar("252525", "46456456", 100);
		
		this.iInventariService.buscar("252525");
		
		
		//50 unidades producto p1 - b1
		p1.setStock(50);
		this.iProductoService.actualizar(p1);
		this.iBodegaService.guardar(b1);
		this.iInventariService.buscar("46456456");
		System.out.println(p1);
				
		//100 unidades producto p2 b1
		p2.setStock(100);
		this.iProductoService.actualizar(p2);
		this.iBodegaService.guardar(b1);
		this.iInventariService.buscar("46456456");
		System.out.println(p2);
	
		//20 unidades producto p1 - b1
		p1.setStock(20);
		this.iProductoService.actualizar(p1);
		this.iInventariService.buscar("46456456");
		System.out.println(p1);
		
		System.out.println(i);
		}
}
