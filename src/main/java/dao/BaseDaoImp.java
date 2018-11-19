package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author YaoWenHao
 * @Title: BaseDaoImp
 * @ProjectName ssh
 * @Description: TODO
 * @date 2018/11/19 19:28
 */
public class BaseDaoImp<T> implements BaseDao<T> {

    private Class genericSuperClass;

    public BaseDaoImp() {
        Type[] types = ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments();
        genericSuperClass = (Class) types[0];
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public List<T> findByLimit() {
        return null;
    }
}
