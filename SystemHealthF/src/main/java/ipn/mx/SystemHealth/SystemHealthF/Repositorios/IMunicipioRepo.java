package ipn.mx.SystemHealth.SystemHealthF.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ipn.mx.SystemHealth.SystemHealthF.Model.municipio;

public interface IMunicipioRepo extends JpaRepository<municipio, Integer>
{
List<municipio> findAllByCveEnt(String cve);
}
