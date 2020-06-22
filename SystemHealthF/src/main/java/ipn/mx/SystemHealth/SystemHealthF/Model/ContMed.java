package ipn.mx.SystemHealth.SystemHealthF.Model;

public class ContMed {
	
	private String medicamento;
	private int cantidad;
	
	public ContMed(String medicamento, int cantidad)
	{
		this.medicamento = medicamento;
		this.cantidad = cantidad;
	}
	public String getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ContMed [medicamento=" + medicamento + ", cantidad=" + cantidad + "]";
	}
	
	
	

}
