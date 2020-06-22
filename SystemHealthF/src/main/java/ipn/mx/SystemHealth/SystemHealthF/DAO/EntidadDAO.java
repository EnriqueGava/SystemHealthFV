package ipn.mx.SystemHealth.SystemHealthF.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipn.mx.SystemHealth.SystemHealthF.Model.cantidades;
import ipn.mx.SystemHealth.SystemHealthF.Model.entidad;
import ipn.mx.SystemHealth.SystemHealthF.Model.paciente;
import ipn.mx.SystemHealth.SystemHealthF.Repositorios.ICantidadesRepo;
import ipn.mx.SystemHealth.SystemHealthF.Repositorios.IEntidadRepo;
@Service
public class EntidadDAO 
{
	@Autowired
	private IEntidadRepo repo;
	public List<entidad> listarEntidades()
	{
		return repo.findAll();
	}
	
	public entidad getEnrtidad(String id)
	{
		return repo.getOne(id);
	}
	
	public void addEntidad(entidad pac)
	{
		repo.save(pac);
	}
	
	public void deleteEntidad(String id)
	{
		repo.deleteById(id);
	}

}
