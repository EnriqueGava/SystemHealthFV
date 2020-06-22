package ipn.mx.SystemHealth.SystemHealthF.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ipn.mx.SystemHealth.SystemHealthF.Model.paciente;

public interface IPacienteRepo extends JpaRepository<paciente, Integer> 
{
	Optional<paciente> findAllByIdUsuario(String id);

}
