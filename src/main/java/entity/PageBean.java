package entity;

/**
 * @author yaowenhao
 * @Title: PageBean
 * @ProjectName ssh
 * @Description: TODO
 * @date 2018/11/25 20:41
 */
public class PageBean {

    private int offset;

    private int limit;

    private int pageNum;

    public PageBean(int limit, int offset) {
        this.offset = offset;
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPageNum() {
        return offset / limit + 1;
    }
}
