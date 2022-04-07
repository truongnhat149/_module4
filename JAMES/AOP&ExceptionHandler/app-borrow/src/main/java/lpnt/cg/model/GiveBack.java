package lpnt.cg.model;

import javax.persistence.*;

@Entity
@Table(name = "givebacks")
public class GiveBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book nameBook;

    public GiveBack(Long id, Book nameBook) {
        this.id = id;
        this.nameBook = nameBook;
    }

    public GiveBack() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getNameBook() {
        return nameBook;
    }

    public void setNameBook(Book nameBook) {
        this.nameBook = nameBook;
    }
}
