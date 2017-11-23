package com.smarttmt.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

/**
 * Clase controladora que expone los servicios asociados a la entidad
 * EstadoCuenta
 * 
 * @author desarrollo05
 *
 */
@RestController
public class EstadoCuentaController {

	// Variable estatica para el manejo del log de la clase
	private static final Logger LOGGER = LoggerFactory.getLogger(EstadoCuentaController.class);
	// Inyeccion de la interfaz EstadoCuentaService
	private final com.smarttmt.service.EstadoCuentaService estadoCuentaService;

	/**
	 * Constructor para inicializar la variable EstadoCuentaService
	 * 
	 * @param estadoCuentaService
	 */
	@Autowired
	public EstadoCuentaController(final com.smarttmt.service.EstadoCuentaService estadoCuentaService) {
		this.estadoCuentaService = estadoCuentaService;
	}

	/**
	 * Metodo que retorna todo el listado del estado de cuenta.
	 * 
	 * @param tiimcodi
	 * @return - Listado del tipo entidad EstadoCuenta
	 */
	@ApiOperation(value = "Devuelve el listado de las obligaciones del cliente agrupadas por Tipo De ImPuesto", responseContainer = "List")
	@GetMapping(value = "/estadocutipoimpu", produces = { "application/json" })
	public java.util.List<com.smarttmt.domain.EstadoCuenta> getAllEstadoCuenta() {
		LOGGER.debug("Inicia Proceso de Consulta todos los estados de cuenta del sistema");
		return estadoCuentaService.findAllEstadoCuenta();
	}

	/**
	 * Metodo para realizar el guardado de un estado de cuenta agrupado por tercero
	 * y tipo de impuesto
	 * 
	 * @param estadoCuenta
	 */
	@ApiOperation(value = "Guardar un estado de cuenta resumido por tercero", responseContainer = "Nothing")
	@RequestMapping(value = "/estadocuentaguardar", method = RequestMethod.POST, consumes = { "application/json" })
	public void saveEstadoCuenta(@RequestBody @Valid final com.smarttmt.domain.EstadoCuenta estadoCuenta) {
		LOGGER.debug("Recibe la petición para crear el Estado Cuenta ", estadoCuenta);
		estadoCuentaService.guardarEstadoCuenta(estadoCuenta);
	}

	/**
	 * Metodo para retornar el objeto estado cuenta cuando el filtro de busqueda sea
	 * el codigo del tercero
	 * 
	 * @param terccodi
	 * @return - Objeto estado cuenta
	 */
	@GetMapping(value = "/estadocuentaterccodi/{terccodi}", produces = { "application/json" })
	public com.smarttmt.domain.EstadoCuenta obtenerEstadoCuenta(@PathVariable String terccodi) {
		LOGGER.debug("Recibio Peticion para obtener el estado de cuenta por tercero");
		return estadoCuentaService.estadoCuentaByTercCodi(terccodi);

	}

}
