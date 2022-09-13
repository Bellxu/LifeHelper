package com.lifehelper.android.bean;

import java.io.Serializable;
import java.util.List;

public class SearchCookResultBean implements Serializable {

    private static final long serialVersionUID = -1463946637736817718L;
    /**
     * status
     */
    private int status;
    /**
     * msg
     */
    private String msg;
    /**
     * result
     */
    private ResultDTO result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public static class ResultDTO {
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
}
