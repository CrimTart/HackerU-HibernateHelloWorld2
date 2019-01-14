package ru.hackeru.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
		Session session = null;
		Transaction tx=null;
		
		try {
			session = HibernateUtil.configureSessionFactory().openSession();
			tx = session.beginTransaction();
			
			// Creating Contact entity that will be save to the sqlite database
			Contact myContact = new Contact(30, "My Name", "my_email@email.com");
			Contact yourContact = new Contact(31, "Your Name", "your_email@email.com");
			
			// Saving to the database
			session.save(myContact);
			session.save(yourContact);
			
			// Committing the change in the database.
			session.flush();
			tx.commit();
			
			// Fetching saved data
			List<Contact> contactList = session.createQuery("from Contact").list();
			
			for (Contact contact : contactList) {
				System.out.println("Id: " + contact.getId() + " | Name:"  + contact.getName() + " | Email:" + contact.getEmail());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			
			// Rolling back the changes to make the data consistent in case of any failure 
			// in between multiple database write operations.
			tx.rollback();
		} finally{
			if(session != null) {
				session.close();
			}
		}
	}
}
