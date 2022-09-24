package com.lifehelper.android.bean;

import java.io.Serializable;
import java.util.List;

public class SearchCookResultBean implements Serializable {
    /**
     * total
     */
    private int total;
    /**
     * num
     */
    private int num;
    /**
     * list
     */
    private List<SearchCookBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<SearchCookBean> getList() {
        return list;
    }

    public void setList(List<SearchCookBean> list) {
        this.list = list;
    }

}
