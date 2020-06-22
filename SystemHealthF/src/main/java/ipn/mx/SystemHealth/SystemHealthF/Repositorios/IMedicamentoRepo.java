package ipn.mx.SystemHealth.SystemHealthF.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ipn.mx.SystemHealth.SystemHealthF.Model.medicamento;

public interface IMedicamentoRepo extends JpaRepository<medicamento, Integer>
{

}
