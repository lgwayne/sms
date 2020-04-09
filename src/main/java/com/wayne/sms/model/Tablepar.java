package com.wayne.sms.model;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.model
 * @Author: lgwayne
 * @CreateTime: 2020-03-22 21:58
 * @Description: ${Description}
 */
public class Tablepar {
    private int pageNum;//页码
    private int pageSize;//数量
    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
