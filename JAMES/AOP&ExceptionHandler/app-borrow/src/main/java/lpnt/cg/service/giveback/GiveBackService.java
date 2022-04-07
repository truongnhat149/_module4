package lpnt.cg.service.giveback;

import lpnt.cg.model.GiveBack;

import java.util.Optional;

public class GiveBackService implements IGiveBackService{
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
