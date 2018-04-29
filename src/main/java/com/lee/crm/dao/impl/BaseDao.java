package com.lee.crm.dao.impl;

import com.lee.crm.dao.DaoInterface;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/27
 * @Description:
 */

@Repository("baseDao")
public class BaseDao<T> implements DaoInterface<T> {

    @Autowired
    private SessionFactory mSessionFactory;

    public SessionFactory getSessionFactory() {
        return mSessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        mSessionFactory = sessionFactory;
    }

    @Override
    public Serializable add(T t) {
        return mSessionFactory.getCurrentSession().save(t);
    }

    @Override
    public void delete(T t) {
        mSessionFactory.getCurrentSession().delete(t);
    }


    @Override
    public void update(T t) {
        mSessionFactory.getCurrentSession().update(t);
    }

    @Override
    public void saveOrUpdate(T t) {
        mSessionFactory.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public T get(String hql) {
        Query query = mSessionFactory.getCurrentSession().createQuery(hql);

        List list = query.list();
        if (list != null && list.size() > 0) {
            return (T) list.get(0);
        }

        return null;
    }

    @Override
    public T get(String hql, Object... params) {
        Query query = mSessionFactory.getCurrentSession().createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        List list = query.list();
        if (list != null && list.size() > 0) {
            return (T) list.get(0);
        }

        return null;
    }

    @Override
    public List<T> find(String hql) {
        Query query = mSessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<T> find(String hql, Object... params) {
        Query query = mSessionFactory.getCurrentSession().createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return query.list();
    }

    @Override
    public List<T> find(String hql, int page, int rows) {
        Query query = mSessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult((page - 1) * rows);
        query.setFetchSize(rows);
        return query.list();
    }

    @Override
    public List<T> find(String hql, int page, int rows, Object... params) {
        Query query = mSessionFactory.getCurrentSession().createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        query.setFirstResult((page - 1) * rows);
        query.setFetchSize(rows);
        return query.list();
    }

    @Override
    public Long count(String hql) {
        Query query = mSessionFactory.getCurrentSession().createQuery(hql);
        return (Long) query.uniqueResult();
    }

    @Override
    public Long count(String hql, Map<String, Object> params) {
        System.out.println("未实现......");
        return null;
    }

    @Override
    public T get(Class<T> c, Serializable id) {
        System.out.println("未实现......");
        return null;
    }

    @Override
    public int executeHql(String hql) {
        System.out.println("未实现......");
        int i = mSessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
        return i;
    }
}
