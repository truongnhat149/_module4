package lpnt.cg.service.picture;

import lpnt.cg.model.Picture;
import lpnt.cg.service.IGeneralService;

public interface IPictureService extends IGeneralService<Picture> {
    Picture like(Long id);
}
