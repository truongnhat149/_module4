package lpnt.cg.repository;

import lpnt.cg.model.GiveBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGiveBackRepository extends JpaRepository<GiveBack, Long> {
}
