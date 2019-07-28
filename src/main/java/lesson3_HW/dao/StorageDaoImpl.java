package lesson3_HW.dao;

import lesson3_HW.beans.Storage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

/**
 * Created by oleg on 27.07.2019.
 */

public class StorageDaoImpl implements GeneralDao<Storage> {


    private SessionFactory sessionFactory;
    private Transaction transaction;

    private SessionFactory createSessionFacrory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    @Override
    public Storage add(Storage storage) {
        try (Session session = createSessionFacrory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.save(storage);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return storage;
    }

    @Override
    public void remove(Long id) {
    }

    @Override
    public Storage getById(Long id) {
        return null;
    }

    @Override
    public Storage update(Storage storage) {
        return storage;
    }

    @Override
    public List<Storage> listAll() {
        return null;
    }
}