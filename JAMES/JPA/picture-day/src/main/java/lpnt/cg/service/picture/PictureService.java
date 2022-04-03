package lpnt.cg.service.picture;

import lpnt.cg.model.Picture;
import lpnt.cg.repository.picture.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PictureService implements IPictureService {

    @Autowired
    public IPictureRepository pictureRepository;

    @Override
    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Picture findById(long id) {
        return pictureRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        pictureRepository.remove(id);
    }

    @Override
    public void save(Picture picture) {
        pictureRepository.save(picture);
    }

    @Override
    public Picture like(Long id) {
        return null;
    }
}
