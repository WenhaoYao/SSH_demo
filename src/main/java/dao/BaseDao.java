package dao;

import java.util.List;

/**
 * @author yaowenhao
 * @Title: BaseDao
 * @ProjectName ssh
 * @Description: TODO
 * @date 2018/11/19 17:30
 */
public interface BaseDao<T> {

    public List<T> findAll();

    public List<T> findByLimit();
}
