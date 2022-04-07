package lpnt.cg.service.borrow;

import lpnt.cg.model.GiveBack;
import lpnt.cg.service.giveback.IGiveBackService;

import java.util.Optional;

public class BorrowService implements IGiveBackService {
    @Override
    public Iterable<GiveBack> findAll() {
        return null;
    }

    @Override
    public Optional<GiveBack> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(GiveBack giveBack) {

    }

    @Override
    public void remove(Long id) {

    }
}
