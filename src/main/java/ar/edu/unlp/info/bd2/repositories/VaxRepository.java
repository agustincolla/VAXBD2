package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class VaxRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Serializable save(Object guardar) throws VaxException {
        Session session = sessionFactory.getCurrentSession();
        return session.save(guardar);
    }

}
