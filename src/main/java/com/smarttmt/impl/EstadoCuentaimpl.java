package com.smarttmt.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.smarttmt.repository.EstadoCuentaRepository;
import com.smarttmt.service.EstadoCuentaService;

@Service
@Validated
public class EstadoCuentaimpl implements EstadoCuentaService {
	// Varaible estatica LOGGER para llevar el log de la clase.
	private static final Logger LOGGER = LoggerFactory.getLogger(EstadoCuentaimpl.class);
	// Variable asociado a la interfaz EstadoCuentaRepository para extender la
	// funcionalidad
	private final EstadoCuentaRepository estadoCuentaRepository;

	/**
	 * Construcutor de la clase EstadoCuentaimpl, inyecta el objeto interfaz
	 * 
	 * @param estadoCuentaRepository
	 */
	@Autowired
	public EstadoCuentaimpl(final EstadoCuentaRepository estadoCuentaRepository) {
		this.estadoCuentaRepository = estadoCuentaRepository;
	}

	/**
	 * Metodo sobreescrito que devuelve el listado de los documentos almacenados
	 * asociados a la entidad estadoCuenta.
	 */
	@Override
	public List<com.smarttmt.domain.EstadoCuenta> findAllEstadoCuenta() {
		LOGGER.debug("Inicia Proceso de Consulta del estado de cuenta por tipo impuesto");
		return estadoCuentaRepository.findAll();
	}

	/**
	 * Metodo sobreescrito para guardar el objeto EstadoCuenta.
	 */
	@Override
	public void guardarEstadoCuenta(com.smarttmt.domain.EstadoCuenta estadoCuenta) {
		LOGGER.debug("Recibe la petición para crear el Estado Cuenta ", estadoCuenta);
		estadoCuentaRepository.deleteAll();
		estadoCuentaRepository.save(estadoCuenta);
	}

	/**
	 * Metodo sobreescrito para obtener el objeto estado de cuenta por codigo del
	 * tercero
	 */
	@Override
	public com.smarttmt.domain.EstadoCuenta estadoCuentaByTercCodi(String terccodi) {
		LOGGER.debug("Busca estado cuenta por tercero ", terccodi);
		return estadoCuentaRepository.findOne(terccodi);
	}

}
