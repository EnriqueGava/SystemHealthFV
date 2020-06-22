package ipn.mx.SystemHealth.SystemHealthF.DAO;

import org.springframework.web.multipart.MultipartFile;

public class Usuario {
	
	private String userName;
    private String password;
    private String role;
    private String email;
    private MultipartFile photo;
    
    public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getEstatura() {
		return estatura;
	}
	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTipodesangre() {
		return tipodesangre;
	}
	public void setTipodesangre(String tipodesangre) {
		this.tipodesangre = tipodesangre;
	}
	private int idPaciente;
	private String nombre;
    private String apellidos;
    private int edad;
    private int peso;
	private int estatura;
    private String sexo;
    private String tipodesangre;
    
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

}
