package lpnt.cg.service.picture;

import lpnt.cg.model.Picture;
import lpnt.cg.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PictureService implements IPictureService {

    @Autowired
    public IPictureRepository pictureRepository;

    @Override
    public void remove(Long id) {
        pictureRepository.deleteById(id);
    }

    @Override
    public Iterable<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Optional<Picture> findById(Long id) {
        return pictureRepository.findById(id);
    }

    @Override
    public void save(Picture picture) {
        pictureRepository.save(picture);
    }

    @Override
    public Page<Picture> findAll(Pageable pageable) {
        return pictureRepository.findAll(pageable);
    }

    @Override
    public Page<Picture> findAllByMessageContaining(String message, Pageable pageable) {
        return pictureRepository.findAllByMessageContaining(message, pageable);
    }
}
