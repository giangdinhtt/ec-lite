package org.cath.ec.dao;

import java.util.ArrayList;
import java.util.List;

import org.cath.ec.model.AbstractModel;
import org.cath.ec.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

public abstract class AbstractDao {

    /**
     * Lấy một đối tượng trong cơ sở dữ liệu.
     * 
     * @param cls
     *            Lớp đại diện cho đối tượng.
     * @param objectId
     *            Mã của đối tượng.
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractModel> T get(Class<? extends AbstractModel> cls, String objectId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        T result = null;
        Integer id = null;
        try {
            id = Integer.parseInt(objectId);
        } catch (Exception ex) {
            id = null;
        }
        try {
            transaction = session.beginTransaction();
            if (id != null) {
                result = (T) session.get(cls, id);
            } else {
                result = (T) session.get(cls, objectId);
            }
            initializeObjectForSingleSelect(result);
            transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
            throw he;
        } finally {
            session.close();
        }

        return result;
    }

    /**
     * Lấy một đối tượng trong cơ sở dữ liệu.
     * 
     * @param cls
     *            Lớp đại diện cho đối tượng.
     * @param objectId
     *            Mã của đối tượng.
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractModel> T get(Class<? extends AbstractModel> cls, int objectId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T) session.get(cls, objectId);
            initializeObjectForSingleSelect(result);
            transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
            throw he;
        } finally {
            session.close();
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractModel> List<T> getAll(Class<? extends AbstractModel> cls) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<T> result = null;
        try {
            transaction = session.beginTransaction();
            Criteria crit = session.createCriteria(cls);
            result = new ArrayList<T>(crit.list());
            for (int i = 0; i < result.size(); i++) {
                initializeObjectForMultiSelect(result.get(i));
            }

            transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
            throw he;
        } finally {
            session.close();
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public <T extends AbstractModel> List<T> getAll(Class<? extends AbstractModel> cls, int start, int limit, String sortBy, boolean sortASC) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<T> result = null;
        try {
            transaction = session.beginTransaction();
            Criteria crit = session.createCriteria(cls).setFirstResult(start).setMaxResults(limit);
            if (sortBy != null && sortBy.trim().length() > 0) {
                crit = (sortASC) ? crit.addOrder(Order.asc(sortBy)) : crit.addOrder(Order.desc(sortBy));
            }
            result = new ArrayList<T>(crit.list());
            for (int i = 0; i < result.size(); i++) {
                initializeObjectForMultiSelect(result.get(i));
            }

            transaction.commit();
        } catch (HibernateException he) {
            transaction.rollback();
            throw he;
        } finally {
            session.close();
        }

        return result;
    }

    /**
     * Lưu hoặc cập nhật một đối tượng trong cơ sở dữ liệu.
     * 
     * @param object
     * @return
     */
    public <T extends AbstractModel> boolean save(T object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            initializeObjectForUpdate(object);
            transaction.commit();
            result = true;
        } catch (HibernateException he) {
            transaction.rollback();
            throw he;
        } finally {
            session.close();
        }

        return result;
    }

    /**
     * Xóa một đối tượng khỏi cơ sở dữ liệu.
     * 
     * @param object
     * @return
     */
    public <T extends AbstractModel> boolean delete(T object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
            result = true;
        } catch (HibernateException he) {
            transaction.rollback();
            throw he;
        } finally {
            session.close();
        }

        return result;
    }

    /**
     * Xóa một đối tượng khỏi cơ sở dữ liệu.
     * 
     * @param cls
     *            Lớp đại diện cho đối tượng.
     * @param objectId
     *            Mã của đối tượng.
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractModel> boolean delete(Class<? extends AbstractModel> cls, String objectId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        T persistentObject = null;
        Integer id = null;
        try {
            id = Integer.parseInt(objectId);
        } catch (Exception ex) {
            id = null;
        }
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            if (id != null) {
                persistentObject = (T) session.get(cls, id);
            } else {
                persistentObject = (T) session.get(cls, objectId);
            }
            session.delete(persistentObject);
            transaction.commit();
            result = true;
        } catch (HibernateException he) {
            transaction.rollback();
            throw he;
        } finally {
            session.close();
        }

        return result;
    }

    /**
     * Xóa một đối tượng khỏi cơ sở dữ liệu.
     * 
     * @param cls
     *            Lớp đại diện cho đối tượng.
     * @param objectId
     *            Mã của đối tượng.
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends AbstractModel> boolean delete(Class<? extends AbstractModel> cls, int objectId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        T persistentObject = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            persistentObject = (T) session.get(cls, objectId);
            session.delete(persistentObject);
            transaction.commit();
            result = true;
        } catch (HibernateException he) {
            transaction.rollback();
            throw he;
        } finally {
            session.close();
        }

        return result;
    }

    protected <T extends AbstractModel> void initializeObjectForSingleSelect(T object) {
    }

    protected <T extends AbstractModel> void initializeObjectForMultiSelect(T object) {
    }

    protected <T extends AbstractModel> void initializeObjectForUpdate(T object) {
    }
}
