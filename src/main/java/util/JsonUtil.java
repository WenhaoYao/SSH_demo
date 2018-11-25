package util;

import entity.Univercity;
import org.json.JSONArray;

import java.util.List;

/**
 * @author yaowenhao
 * @Title: JsonUtil
 * @ProjectName ssh
 * @Description: TODO
 * @date 2018/11/25 16:22
 */
public class JsonUtil {

    public static JSONArray JsonFormatter(List<Univercity> list){
        JSONArray array = new JSONArray(list);
        return array;
    }

}
