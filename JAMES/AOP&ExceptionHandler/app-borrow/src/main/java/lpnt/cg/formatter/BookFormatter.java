package lpnt.cg.formatter;

import lpnt.cg.model.Book;

import lpnt.cg.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class BookFormatter implements Formatter<Book> {

private IBookService BookService;

@Autowired
public BookFormatter(IBookService BookService) {
        this.BookService = (IBookService) BookService;
        }

@Override
public Book parse(String text, Locale locale) throws ParseException {
        Optional<Book> BookOptional = BookService.findById(Long.parseLong(text));
        return BookOptional.orElse(null);
        }

@Override
public String print(Book object, Locale locale) {
        return "[" + object.getId() + ", " + object.getName() + "]";
        }

        }

