package ipn.mx.SystemHealth.SystemHealthF.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ipn.mx.SystemHealth.SystemHealthF.Model.doctor;

import java.util.Optional;

public interface IDoctorRepo extends JpaRepository<doctor, Integer>
{
	Optional<doctor> findAllByIdUsuario(String id);
	
}
