package ipn.mx.SystemHealth.SystemHealthF.Model;

import java.io.InputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="confirmation")
public class confirmation
{
	@Id	
	@Column(name="idconfirmation", nullable=false , unique = true)
	private int idConfirmation;
	
	@Column(name="idusuario", nullable=false , unique = true)
	private String idUsuario;

	private int confirmation;

	public int getIdConfirmation() {
		return idConfirmation;
	}

	public void setIdConfirmation(int idConfirmation) {
		this.idConfirmation = idConfirmation;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(int confirmation) {
		this.confirmation = confirmation;
	}

	@Override
	public String toString() {
		return "confirmation [idConfirmation=" + idConfirmation + ", idUsuario=" + idUsuario + ", confirmation="
				+ confirmation + ", getIdConfirmation()=" + getIdConfirmation() + ", getIdUsuario()=" + getIdUsuario()
				+ ", getConfirmation()=" + getConfirmation() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
