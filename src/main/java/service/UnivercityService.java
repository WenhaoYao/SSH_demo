package service;

import dao.UnivercityDao;
import entity.PageBean;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.JsonUtil;

import javax.annotation.Resource;

/**
 * @author yaowenhao
 * @Title: UnivercityService
 * @ProjectName ssh
 * @Description: TODO
 * @date 2018/11/20 23:28
 */
@Transactional(rollbackFor = Exception.class)
@Service(value = "univercityService")
public class UnivercityService {

    @Resource(name = "univercityDaoImp")
    private UnivercityDao univercityDao;

    public JSONArray findAll(){
        return JsonUtil.JsonFormatter(univercityDao.findAll());
    }

    public JSONArray findList(PageBean pageBean) {
        return JsonUtil.JsonFormatter(univercityDao.findByLimit(pageBean));
    }

    public Long totalCount(){
        return univercityDao.totalCount();
    }
}
