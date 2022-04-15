package lpnt.cg.repository;

import lpnt.cg.model.Customer;
import lpnt.cg.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {

}
