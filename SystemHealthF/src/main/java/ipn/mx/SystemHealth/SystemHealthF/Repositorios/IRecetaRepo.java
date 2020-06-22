package ipn.mx.SystemHealth.SystemHealthF.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ipn.mx.SystemHealth.SystemHealthF.Model.receta;

public interface IRecetaRepo extends JpaRepository<receta, Integer>
{
	List<receta> findAllByIdPaciente(int id);
}
