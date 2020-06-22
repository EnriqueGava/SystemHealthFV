package ipn.mx.SystemHealth.SystemHealthF.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cantidades")
public class cantidades 
{

	@Id	
	@Column(name="idcantidades", nullable=false , unique = true)
	private int idCantidades;

	@Column(name="idmedicamento" )
	private int idMedicamento;
	
	private int cantidad;
	
	private String descripcion;

	public int getIdCantidades() {
		return idCantidades;
	}

	public void setIdCantidades(int idCantidades) {
		this.idCantidades = idCantidades;
	}

	public int getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "cantidades [idCantidades=" + idCantidades + ", idMedicamento=" + idMedicamento + ", cantidad="
				+ cantidad + ", descripcion=" + descripcion + ", getIdCantidades()=" + getIdCantidades()
				+ ", getIdMedicamento()=" + getIdMedicamento() + ", getCantidad()=" + getCantidad()
				+ ", getDescripcion()=" + getDescripcion() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
