package com.veranitou.dao;

public class Consulta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer consultaId;

	private String nombre;

	private String email;

	private String consulta;

	public Integer getConsultaId() {
		return this.consultaId;
	}

	public void setConsultaId(Integer consultaId) {
		this.consultaId = consultaId;
	}

	public String getNombre(){
		return this.nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getConsulta(){
		return this.consulta;
	}

	public void setConsulta(String consulta){
		this.consulta = consulta;
	}
}