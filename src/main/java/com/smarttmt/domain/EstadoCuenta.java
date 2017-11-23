package com.smarttmt.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class EstadoCuenta implements Serializable {

	@Id
	// Codigo del tercero
	private String terccodi;
	// Codigo de la empresa
	private String emprcodi;
	// Codigo del tipo de impuesto
	private String tiimcodi;
	// Descripcion del tipo de impuesto
	private String tiimdesc;
	// Clase de documento del tercero
	private String clasdocu;
	// Numero de documento del tercero
	private String numedocu;
	// Codigo del estado de la obligacion
	private String estacodi;
	// Valor agrupado por tipo de impuesto
	private String valor;

	public EstadoCuenta() {

	}

	public EstadoCuenta(String terccodi, String emprcodi, String tiimcodi, String tiimdesc, String clasdocu,
			String numedocu, String estacodi, String valor) {
		
		this.terccodi = terccodi;
		this.emprcodi = emprcodi;
		this.tiimcodi = tiimcodi;
		this.tiimdesc = tiimdesc;
		this.clasdocu = clasdocu;
		this.numedocu = numedocu;
		this.estacodi = estacodi;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "EstadoCuenta [, emprcodi=" + emprcodi + ", tiimcodi=" + tiimcodi + ", tiimdesc=" + tiimdesc
				+ ", clasdocu=" + clasdocu + ", terccodi=" + terccodi + ", numedocu=" + numedocu + ", estacodi="
				+ estacodi + ", valor=" + valor + "]";
	}

	public String getEmprcodi() {
		return emprcodi;
	}

	public void setEmprcodi(String emprcodi) {
		this.emprcodi = emprcodi;
	}

	public String getTiimcodi() {
		return tiimcodi;
	}

	public void setTiimcodi(String tiimcodi) {
		this.tiimcodi = tiimcodi;
	}

	public String getTiimdesc() {
		return tiimdesc;
	}

	public void setTiimdesc(String tiimdesc) {
		this.tiimdesc = tiimdesc;
	}

	public String getClasdocu() {
		return clasdocu;
	}

	public void setClasdocu(String clasdocu) {
		this.clasdocu = clasdocu;
	}

	public String getTerccodi() {
		return terccodi;
	}

	public void setTerccodi(String terccodi) {
		this.terccodi = terccodi;
	}

	public String getNumedocu() {
		return numedocu;
	}

	public void setNumedocu(String numedocu) {
		this.numedocu = numedocu;
	}

	public String getEstacodi() {
		return estacodi;
	}

	public void setEstacodi(String estacodi) {
		this.estacodi = estacodi;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
