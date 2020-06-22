package ipn.mx.SystemHealth.SystemHealthF.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipn.mx.SystemHealth.SystemHealthF.Model.User;
import ipn.mx.SystemHealth.SystemHealthF.Model.doctor;
import ipn.mx.SystemHealth.SystemHealthF.Repositorios.IDoctorRepo;

@Service
public class DoctorDAO 
{
	@Autowired
	private IDoctorRepo repo;
	public List<doctor> listarDoctores()
	{
		return repo.findAll();
	}
	
	public doctor getDoctor(int id)
	{
		return repo.getOne(id);
	}
	
	public void addDoctor(doctor pac)
	{
		repo.save(pac);
	}
	
	public void deleteDoctor(int id)
	{
		repo.deleteById(id);
	}
	
	public doctor getDocByUserId(String id)
	{
		Optional<doctor> doc = repo.findAllByIdUsuario(id);
		return doc.get();
	}

}
