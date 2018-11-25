package dao;

import entity.PageBean;
import entity.Univercity;

import java.util.List;

/**
 * @author yaowenhao
 * @Title: UnivercityDao
 * @ProjectName ssh
 * @Description: TODO
 * @date 2018/11/20 21:23
 */
public interface UnivercityDao {

    List<Univercity> findAll();

    List<Univercity> findByLimit(PageBean pageBean);

    Long totalCount();
}
