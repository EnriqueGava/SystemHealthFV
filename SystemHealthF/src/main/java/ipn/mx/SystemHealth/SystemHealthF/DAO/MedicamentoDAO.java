package ipn.mx.SystemHealth.SystemHealthF.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipn.mx.SystemHealth.SystemHealthF.Model.medicamento;
import ipn.mx.SystemHealth.SystemHealthF.Repositorios.IMedicamentoRepo;

@Service
public class MedicamentoDAO 
{
	@Autowired
	private IMedicamentoRepo repo;
	public List<medicamento> listarMedicamentos()
	{
		return repo.findAll();
	}
	
	public medicamento getMedicamento(int id)
	{
		return repo.getOne(id);
	}
	
	public void addMedicamento(medicamento pac)
	{
		repo.save(pac);
	}
	
	public void deleteMedicamento(int id)
	{
		repo.deleteById(id);
	}

}
