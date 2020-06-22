package ipn.mx.SystemHealth.SystemHealthF.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipn.mx.SystemHealth.SystemHealthF.Model.receta;
import ipn.mx.SystemHealth.SystemHealthF.Repositorios.IRecetaRepo;

@Service
public class RecetaDAO 
{
	@Autowired
	private IRecetaRepo repo;
	public List<receta> listarRecetas()
	{
		return repo.findAll();
	}
	
	public receta getRecetas(int id)
	{
		return repo.getOne(id);
	}
	
	public void addReceta(receta pac)
	{
		repo.save(pac);
	}
	
	public void deleteReceta(int id)
	{
		repo.deleteById(id);
	}
	
	public List<receta> getRecByIdPaciente(int id)
	{
		List<receta> rec = repo.findAllByIdPaciente(id);
		return rec;
	}

}
