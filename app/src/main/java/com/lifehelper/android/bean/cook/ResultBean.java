package com.lifehelper.android.bean.cook;

public class ResultBean<T> {

    /**
     * code
     */
    private String code;
    /**
     * charge
     */
    private boolean charge;
    /**
     * msg
     */
    private String msg;
    /**
     * result
     */
    private InnerResult<T> result;
    /**
     * requestId
     */
    private String requestId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public InnerResult<T> getResult() {
        return result;
    }

    public void setResult(InnerResult<T> result) {
        this.result = result;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

}
