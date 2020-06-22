package ipn.mx.SystemHealth.SystemHealthF.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipn.mx.SystemHealth.SystemHealthF.Model.paciente;
import ipn.mx.SystemHealth.SystemHealthF.Repositorios.IPacienteRepo;

@Service
public class PacienteDAO 
{
	@Autowired
	private IPacienteRepo repo;
	public List<paciente> listar()
	{
		return repo.findAll();
	}
	
	public paciente getPaciente(int id)
	{
		return repo.getOne(id);
	}
	
	public void addPaciente(paciente pac)
	{
		repo.save(pac);
	}
	
	public void deletePaciente(int id)
	{
		repo.deleteById(id);
	}
	
	public paciente getPacByUserId(String id)
	{
		Optional<paciente> pac = repo.findAllByIdUsuario(id);
		return pac.get();
	}
}
