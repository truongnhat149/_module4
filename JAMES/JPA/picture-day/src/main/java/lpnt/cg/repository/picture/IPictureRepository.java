package lpnt.cg.repository.picture;

import lpnt.cg.model.Picture;
import lpnt.cg.repository.IGeneralRepository;

public interface IPictureRepository extends IGeneralRepository<Picture> {
    Picture like(Long id);
}
