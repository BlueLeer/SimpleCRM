package com.lee.crm.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @CreateAuthor: KingIsHappy
 * @CreateDate: 2018/4/28
 * @Description:
 */
public interface DaoInterface<T> {
    /**
     * 向数据库添加一条数据
     *
     * @param t 记录对应的实体类对象
     * @return 添加数据时生成的对象标志符, 也就是ID
     */
    Serializable add(T t);

    /**
     * 删除一条记录
     *
     * @param t
     */
    void delete(T t);

    void update(T t);

    /**
     * 根据数据库中是否已经存在响应的记录选择更新或者插入数据
     */
    void saveOrUpdate(T t);

    /**
     * 查询一条记录
     *
     * @param hql HQL语句
     * @return 返回一个对象
     */
    T get(String hql);


    /**
     * 查询一条语句
     *
     * @param hql    HQL语句
     * @param params 参数
     * @return
     */
    T get(String hql, Object... params);

    /**
     * 返回多条语句
     * @param hql
     * @return
     */
    List<T> find(String hql);

    List<T> find(String hql, Object... params);

    /**
     * 分页查询
     * @param sql
     * @param page 第几页
     * @param rows 每页的行数
     * @return
     */
    List<T> find(String sql, int page, int rows);

    List<T> find(String hql, int page, int rows, Object... params);

    public Long count(String hql);

    public Long count(String hql, Map<String, Object> params);

    public T get(Class<T> c, Serializable id);

    public int executeHql(String hql);

}
