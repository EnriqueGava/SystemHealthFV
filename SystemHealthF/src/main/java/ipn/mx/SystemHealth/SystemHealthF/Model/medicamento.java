package ipn.mx.SystemHealth.SystemHealthF.Model;

import java.io.InputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicamento")
public class medicamento 
{
	@Id
	@Column(name="idmedicamento", nullable=false , unique = true)
	private int idmedicamento;
	
	private String nombre;
	
	private String dosis;

	public int getIdmedicamento() {
		return idmedicamento;
	}

	public void setIdmedicamento(int idmedicamento) {
		this.idmedicamento = idmedicamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDosis() {
		return dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	@Override
	public String toString() {
		return "medicamento [idmedicamento=" + idmedicamento + ", nombre=" + nombre + ", dosis=" + dosis
				+ ", getIdmedicamento()=" + getIdmedicamento() + ", getNombre()=" + getNombre() + ", getDosis()="
				+ getDosis() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
