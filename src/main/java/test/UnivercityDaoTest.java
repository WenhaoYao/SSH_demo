package test;

import entity.Univercity;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author YaoWenHao
 * @Title: UnivercityDaoTest
 * @ProjectName ssh
 * @Description: TODO
 * @date 2018/11/19 19:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UnivercityDaoTest extends HibernateDaoSupport {

    @Autowired
    public void setMySessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }


    @Test
    public void getList(){
        DetachedCriteria criteria = DetachedCriteria.forClass(Univercity.class);
        List<Univercity> list = (List<Univercity>) this.getHibernateTemplate().findByCriteria(criteria);
        for (Univercity u:
             list) {
            System.out.println(u);
        }
    }
}

