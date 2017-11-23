package com.smarttmt.controllertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Clase para la realizacion de los Test Asociados al controlador
 * (EstadoCuentaController).
 * 
 * @author desarrollo05
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = com.smarttmt.controller.EstadoCuentaController.class, secure = false)
public class EstadoCuentaControllerTest {

	// Variable estatica para el manejo del log de la clase.
	private static final Logger LOGGER = LoggerFactory.getLogger(EstadoCuentaControllerTest.class);
	// Variable del tipo estadoCuenta para validar la respuesta del test.
	private com.smarttmt.domain.EstadoCuenta estadoCuenta;
	// Constante con el valor del numero de documento del tercero
	private final String TERCCODI = "94556762";
	// Constante con el valor esperado de la respuesta del test
	private final String EXPECTED = "{terccodi:\"94556762\",emprcodi:\"01\",tiimcodi:\"01\","
			+ "tiimdesc:\"Predial\",clasdocu:\"cc\",numedocu:\"94556762\",estacodi:\"ac\"" + ",valor:\"2000000\"}";

	// Bloque inicalizador del objeto respuesta
	{
		estadoCuenta = new com.smarttmt.domain.EstadoCuenta("94556762", "01", "01", "Predial", "cc", "94556762", "ac",
				"1000000");
	}

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private com.smarttmt.service.EstadoCuentaService estadoCuentaService;

	/**
	 * Metodo para realizar el test asociado a la consulta del estado de cuenta por
	 * numero de documento del tercero
	 * 
	 * @throws Exception
	 */
	@Test
	public void getEstadoCuentaByTercCodi() throws Exception {
		Mockito.when(estadoCuentaService.estadoCuentaByTercCodi(Mockito.anyString())).thenReturn(estadoCuenta);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/estadocuentaterccodi/" + TERCCODI)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals(EXPECTED, result.getResponse().getContentAsString(), false);
	}
}
