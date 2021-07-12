package com.agendas.demo.entidadesDTO;

public class CuotaModeradoraDTO {

	
	private Long id;
	private Float valor;
	private Long tipoCita;
	private Long tipoContrato;
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Long getTipoCita() {
		return tipoCita;
	}
	public void setTipoCita(Long tipoCita) {
		this.tipoCita = tipoCita;
	}
	public Long getTipoContrato() {
		return tipoContrato;
	}
	public void setTiposContrato(Long tiposContrato) {
		this.tipoContrato = tiposContrato;
	}
	
	
}
