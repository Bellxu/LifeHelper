package com.lifehelper.android.bean.cook;

import java.util.List;

public class SearchCookListBean {
    //0 刷新 1.加载更多
    int requestType;
    List<SearchCookBean> list;

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public List<SearchCookBean> getList() {
        return list;
    }

    public void setList(List<SearchCookBean> list) {
        this.list = list;
    }
}
