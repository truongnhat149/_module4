package lpnt.cg.service.picture;

import lpnt.cg.model.Picture;
import lpnt.cg.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPictureService extends IGeneralService<Picture> {

    List<Picture> like(Long id);

    Page<Picture> findAll(Pageable pageable);

    Page<Picture> findAllByMessageContaining(String message, Pageable pageable);
}
