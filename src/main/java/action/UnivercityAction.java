package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.PageBean;
import entity.Univercity;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import service.UnivercityService;
import util.ResponseUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yaowenhao
 * @Title: UnivercityAction
 * @ProjectName ssh
 * @Description: TODO
 * @date 2018/11/25 16:55
 */
@Controller(value = "univercityAction")
public class UnivercityAction extends ActionSupport implements ModelDriven {

    private Univercity univercity;

    @Override
    public Univercity getModel() {
        return univercity;
    }

    @Resource(name = "univercityService")
    private UnivercityService univercityService;

    public String list() throws IOException {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String limit = request.getParameter("limit");
        String offset = request.getParameter("offset");
        PageBean pageBean = new PageBean(Integer.parseInt(limit), Integer.parseInt(offset));
        JSONArray jsonArray = univercityService.findList(pageBean);
        Long total = univercityService.totalCount();
        JSONObject results = new JSONObject();
        results.put("rows", jsonArray);
        results.put("total", total);
        ResponseUtil.write(response, results);
        return NONE;
    }
}
