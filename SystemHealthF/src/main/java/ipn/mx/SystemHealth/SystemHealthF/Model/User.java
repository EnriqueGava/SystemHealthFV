package ipn.mx.SystemHealth.SystemHealthF.Model;

import java.sql.Blob;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class User {
    @Id
    @Column(name="idusuario", nullable=false , unique = true)
    private String userName;
    private String password;
    private String role;
    private String email;
    @Lob
    @Column(name="foto")
    private Blob photo;
    
    public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    private int confirmation;


    public int getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(int confirmation) {
		this.confirmation = confirmation;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


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

}
