package com.wayne.sms.model;

import java.io.Serializable;
import java.util.List;

/**
 * @BelongsProject: sms
 * @BelongsPackage: com.wayne.sms.model
 * @Author: lgwayne
 * @CreateTime: 2020-03-22 21:59
 * @Description: ${Description}
 */
public class TableSplitResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private  Integer page;
    private Long total;
    private List<T> rows;


    public TableSplitResult() {
    }

    public TableSplitResult(Integer page, Long total, List<T> rows) {
        this.page = page;
        this.total = total;
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}
