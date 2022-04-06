package lpnt.cg.repository;

import lpnt.cg.model.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPictureRepository extends PagingAndSortingRepository<Picture, Long> {
    Page<Picture> findAllByMessageContaining(String message, Pageable pageable);
}
