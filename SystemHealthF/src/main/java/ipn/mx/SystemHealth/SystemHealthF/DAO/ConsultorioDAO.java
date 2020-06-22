package ipn.mx.SystemHealth.SystemHealthF.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipn.mx.SystemHealth.SystemHealthF.Model.cantidades;
import ipn.mx.SystemHealth.SystemHealthF.Model.consultorio;
import ipn.mx.SystemHealth.SystemHealthF.Model.paciente;
import ipn.mx.SystemHealth.SystemHealthF.Repositorios.IConsultorioRepo;
@Service
public class ConsultorioDAO 
{
	@Autowired
	private IConsultorioRepo repo;
	public List<consultorio> listarConsultorio()
	{
		return repo.findAll();
	}
	
	public consultorio getConsultorio(int id)
	{
		return repo.getOne(id);
	}
	
	public void addConsultorio(consultorio pac)
	{
		repo.save(pac);
	}
	
	public void deleteConsultorio(int id)
	{
		repo.deleteById(id);
	}
	
	public consultorio getConsultorioByIdDoc(int id) {
		Optional<consultorio> cons = repo.findAllByIdDoctor(id);
		consultorio aux = new consultorio();
		if(cons.isEmpty()) {
			System.out.println("if:");
			aux.setIdconsultorio(0);
			return aux;
		}else
			return cons.get();
		
	}

}
