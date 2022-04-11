package lpnt.cg.repository;

import lpnt.cg.model.SmartPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends CrudRepository<SmartPhone, Long> {
}
