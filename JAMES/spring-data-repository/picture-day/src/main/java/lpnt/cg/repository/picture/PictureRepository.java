package lpnt.cg.repository.picture;

import lpnt.cg.model.Picture;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PictureRepository implements IPictureRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Picture> findAll() {
        TypedQuery<Picture> query = em.createQuery("select c from Picture c", Picture.class);
        return query.getResultList();
    }

    @Override
    public Picture findById(Long id) {
        TypedQuery<Picture> query = em.createQuery("select c from Picture c where  c.id=:id", Picture.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void remove(Long id) {
        Picture picture = findById(id);
        if (picture != null) {
            em.remove(picture);
        }
    }

    @Override
    public void save(Picture picture) {
        if (picture.getId() != null) {
            em.merge(picture);
        } else {
            em.persist(picture);
        }
    }

    @Override
    public Picture like(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            SessionBuilder<SessionBuilder> sessionFactory = null;
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Picture comment = findById(id);
            comment.setLikeCount(comment.getLikeCount()+1);
            session.saveOrUpdate(comment);
            transaction.commit();
            return comment;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}
