package vn.cg.service;

import org.hibernate.SessionFactory;
import vn.cg.model.Music;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class HibernateMusicService implements IMusicService {

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;


    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Music> findAll() {
        String queryStr = "SELECT ma FROM MUSICS AS ma";
        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
        return query.getResultList();
    }

    @Override
    public Music findById(int id) {
        String queryStr = "SELECT m FROM MUSICS AS m WHERE m.id = :id";
        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
        return query.getSingleResult();
    }

    @Override
    public void save(Music music) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            List<Music> musics = findAll();

            if (!musics.equals(music)) {
                session.saveOrUpdate(music);
                transaction.commit();
            } else {
                Music orgin = findById(music.getId());
                orgin.setNameSong(music.getNameSong());
                orgin.setSinger(music.getSinger());
                orgin.setCategory(music.getCategory());
                orgin.setSound(music.getSound());

                session.saveOrUpdate(orgin);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(int id, Music music) {

    }

    @Override
    public void remove(int id) {

    }
}
