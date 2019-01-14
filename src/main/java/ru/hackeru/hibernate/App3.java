package ru.hackeru.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class App3 {
    public static void main(String[] args) {
		ContactDao dao = new ContactDao();

		Contact contact = new Contact("mikhail", "gmail");


		dao.add(contact);

		contact.setEmail("mikhail@updatedJdbc.com");
		dao.update(contact);


		for (Contact iter : dao.getAll()) {
			System.out.println(iter);
		}
		System.out.println(dao.getById(1));
	}
}
