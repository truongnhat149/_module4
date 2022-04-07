package lpnt.cg.service.book;

import lpnt.cg.model.Book;
import lpnt.cg.service.IGeneralService;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IBookService extends IGeneralService<Book> {

    Page<Book> findAll(Pageable pageable);

}
