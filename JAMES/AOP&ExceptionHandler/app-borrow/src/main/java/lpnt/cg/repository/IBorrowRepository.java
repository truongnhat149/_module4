package lpnt.cg.repository;

import lpnt.cg.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowRepository extends JpaRepository<Borrow , Long> {
}
