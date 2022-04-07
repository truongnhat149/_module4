package lpnt.cg.service.book;

import lpnt.cg.model.Book;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public class BookService implements IBookService {
    @Override
    public Iterable<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return null;
    }
}
