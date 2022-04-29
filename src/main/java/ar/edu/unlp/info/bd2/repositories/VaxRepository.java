package ar.edu.unlp.info.bd2.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class VaxRepository {
  public SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory() ;
  public Session session= sessionFactory.openSession();
  public void save(Object guardar) {
	  session.beginTransaction();
	  session.save(guardar);
	  session.getTransaction().commit();
	  session.close();
  }
  
}
