package com.smarttmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interfaz que contiene las consultas especificas para la entidad EstadoCuenta
 * 
 * @author desarrollo05
 * 
 *
 */
public interface EstadoCuentaRepository extends MongoRepository<com.smarttmt.domain.EstadoCuenta, String> {
	

}
