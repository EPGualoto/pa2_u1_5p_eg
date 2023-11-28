package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	//CRUD
	public CuentaBancaria buscar(String numero);
			
	public void guardar(CuentaBancaria cuentaBancaria);
			
	public void actualizar(CuentaBancaria cuentaBancaria);
			
	public void eliminar(String numero);
	
	public void agregar( );
}
