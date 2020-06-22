package ipn.mx.SystemHealth.SystemHealthF.DAO;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ipn.mx.SystemHealth.SystemHealthF.Model.User;
import ipn.mx.SystemHealth.SystemHealthF.Model.receta;
import ipn.mx.SystemHealth.SystemHealthF.Repositorios.IRecetaRepo;
import ipn.mx.SystemHealth.SystemHealthF.Repositorios.UserRepository;

@Service
public class UserDAO 
{
	@Autowired
	private UserRepository repo;
	
	public List<User> listarUser()
	{
		return repo.findAll();
	}
	
	public User getUsuario(String userName)
	{
		Optional<User> user = repo.findByUserName(userName);
		return user.get();
	}
	
	@Transactional
	public void addUsuario(User pac)
	{
		repo.save(pac);
	}
	
	public void deleteUsuario(int id)
	{
		repo.deleteById(id);
	}

}
