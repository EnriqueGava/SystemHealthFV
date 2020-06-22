package ipn.mx.SystemHealth.SystemHealthF.Repositorios;

import org.springframework.data.repository.CrudRepository;

import ipn.mx.SystemHealth.SystemHealthF.Model.confirmation;

public interface ConfirmationTokenRepository extends CrudRepository<confirmation, String> {
	confirmation findByConfirmation(String confirmation);
}
