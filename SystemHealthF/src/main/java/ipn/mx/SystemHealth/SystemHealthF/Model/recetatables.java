package ipn.mx.SystemHealth.SystemHealthF.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class recetatables {
	/*
	 * receta
	 * paciente
	 * doctor
	 * cantidades
	 * medicamento
	 */
	
	
	//Paciente
	private int idpacienterec;
	//Medicamento
	private int idmedicamentorec;
	//Cantidades
	private int cantidadrec;
	private String descripcionrec;
	private Date fecharec;
	
	//Receta
	private int numRecetarec;
	
	//form
	private int boton;
	
	public int getBoton() {
		return boton;
	}
	public void setBoton(int boton) {
		this.boton = boton;
	}
	public int getIdmedicamentorec() {
		return idmedicamentorec;
	}
	public void setIdmedicamentorec(int idmedicamentorec) {
		this.idmedicamentorec = idmedicamentorec;
	}
	public int getCantidadrec() {
		return cantidadrec;
	}
	public void setCantidadrec(int cantidadrec) {
		this.cantidadrec = cantidadrec;
	}
	public String getDescripcionrec() {
		return descripcionrec;
	}
	public void setDescripcionrec(String descripcionrec) {
		this.descripcionrec = descripcionrec;
	}
	public Date getFecharec() {
		return fecharec;
	}
	public void setFecharec(Date fecharec) {
		this.fecharec = fecharec;
	}
	public int getIdpacienterec() {
		return idpacienterec;
	}
	public void setIdpacienterec(int idpacienterec) {
		this.idpacienterec = idpacienterec;
	}
	public int getNumRecetarec() {
		return numRecetarec;
	}
	public void setNumRecetarec(int numRecetarec) {
		this.numRecetarec = numRecetarec;
	}
	
	
	
	
	
	
	
	
	
	
}
