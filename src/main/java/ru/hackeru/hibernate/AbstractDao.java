package ru.hackeru.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class AbstractDao<T> {
    public void add(T data){
        Transaction trns = null;
        Session session = HibernateUtil.configureSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(data);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void update(T data) {
        Transaction trns = null;
        Session session = HibernateUtil.configureSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(data);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void delete(T data) {
        Transaction trns = null;
        Session session = HibernateUtil.configureSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.delete(data);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public List<T> getAll() {
        List<T> users = null;
        Session session = HibernateUtil.configureSessionFactory().openSession();
        String query = getFromQuery();
        try {
            users = session.createQuery(query).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }

    public T getById(int id) {
        T res = null;
        Session session = HibernateUtil.configureSessionFactory().openSession();
        try {
            String queryString = getFromQuery() + " where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            res = (T)query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return res;
    }

    private String getFromQuery() {
        String actualDao = this.getClass().getName(), fromQuery;
        switch (actualDao) {
            case "ru.hackeru.hibernate.DepartmentDao":
                fromQuery = "from Department";
                break;
            case "ru.hackeru.hibernate.ContactDao":
                fromQuery = "from Contact";
                break;
            case "ru.hackeru.hibernate.WorkerDao":
                fromQuery = "from Worker";
                break;
            case "ru.hackeru.hibernate.AddressDao":
                fromQuery = "from Address";
                break;
            default:
                fromQuery = "Unsupported";
                break;
        }
        return fromQuery;
    }
}
