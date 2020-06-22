package ipn.mx.SystemHealth.SystemHealthF.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipn.mx.SystemHealth.SystemHealthF.Model.cantidades;
import ipn.mx.SystemHealth.SystemHealthF.Repositorios.ICantidadesRepo;

@Service
public class CantidadesDAO 
{
	@Autowired
	private ICantidadesRepo repo;
	public List<cantidades> listarCantidades()
	{
		return repo.findAll();
	}
	
	public cantidades getCantidad(int id)
	{
		return repo.getOne(id);
	}
	
	public void addCantidad(cantidades pac)
	{
		repo.save(pac);
	}
	
	public void deleteCantidad(int id)
	{
		repo.deleteById(id);
	}
	public List<cantidades> getCanByIdCantidades(int id)
	{
		List<cantidades> can = repo.findAllByIdCantidades(id);
		return can;
	}

}
