package com.lifehelper.android.bean.cook;

public class InnerResult<T> {
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
    private T result;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
