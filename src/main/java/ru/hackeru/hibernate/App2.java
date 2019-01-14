package ru.hackeru.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class App2 {

	public static void main(String[] args) {
		Session session = null;
		Transaction tx=null;
		
		try {
			session = HibernateUtil.configureSessionFactory().openSession();
			tx = session.beginTransaction();

			Student student = new Student("Sam","Disilva","Maths");
			Address address = new Address("NYC", "10 Silver street", 3, 4);

			session.persist(address);
			student.setAddress(address);
			session.persist(student);

			List<Student> students = (List<Student>)session.createQuery("from Student ").list();
			for(Student s: students){
				System.out.println("Details : "+s);
			}
			session.flush();
			tx.commit();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally{
			if(session != null) {
				session.close();
			}
		}
	}
}
