package com.smarttmt.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface EstadoCuentaService {

	/**
	 * Metodo abstracto para implementar la busqueda de los estados de cuenta
	 * resumidos
	 * 
	 * @param tiimcodi
	 * @return - Listado de objetos del tipo entidad EstadoCuenta
	 */
	public abstract java.util.List<com.smarttmt.domain.EstadoCuenta> findAllEstadoCuenta();

	/**
	 * Metodo para guardar un estado de cuenta agrupado por tercero y obligacion
	 * 
	 * @param estadoCuenta
	 * @return -
	 */
	public abstract void guardarEstadoCuenta(@NotNull @Valid final com.smarttmt.domain.EstadoCuenta estadoCuenta);

	/**
	 * Metodo para retornar el valor del estado cuenta segun codigo de tercero
	 * 
	 * @param terccodi
	 * @return
	 */
	public abstract com.smarttmt.domain.EstadoCuenta estadoCuentaByTercCodi(String terccodi);

}
