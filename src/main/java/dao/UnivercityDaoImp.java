package dao;

import entity.PageBean;
import entity.Univercity;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yaowenhao
 * @Title: UnivercityDaoImp
 * @ProjectName ssh
 * @Description: TODO
 * @date 2018/11/20 21:24
 */
@Repository(value = "univercityDaoImp")
public class UnivercityDaoImp extends HibernateDaoSupport implements UnivercityDao {

    @Autowired
    public void setMySessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Univercity> findAll(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Univercity.class);
        List<Univercity> list;
        list = (List<Univercity>) this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }

    @Override
    public List<Univercity> findByLimit(PageBean pageBean){
        DetachedCriteria criteria = DetachedCriteria.forClass(Univercity.class);
        List<Univercity> list;
        list = (List<Univercity>) this.getHibernateTemplate().findByCriteria(criteria, pageBean.getOffset(), pageBean.getLimit());
        return list;
    }

    @Override
    public Long totalCount() {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("select count(*) from Univercity ");
        return (Long) query.getSingleResult();
    }
}
