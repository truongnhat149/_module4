package lpnt.cg.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = GiveBack.class, mappedBy = "nameBook")
    private List<GiveBack> giveBack;

    @OneToMany(targetEntity = Borrow.class, mappedBy = "nameBook")
    private List<Borrow> borrow;

    public Book() {
    }

    public Book(Long id, String name, List<GiveBack> giveBack, List<Borrow> borrow) {
        this.id = id;
        this.name = name;
        this.giveBack = giveBack;
        this.borrow = borrow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GiveBack> getGiveBack() {
        return giveBack;
    }

    public void setGiveBack(List<GiveBack> giveBack) {
        this.giveBack = giveBack;
    }

    public List<Borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(List<Borrow> borrow) {
        this.borrow = borrow;
    }
}
