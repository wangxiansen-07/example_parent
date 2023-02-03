package org.example.result;

import java.io.Serializable;

/**
 * @Author: WangTao
 * @Date: 2023-02-01 13:38
 * @Version: 1.0
 * @Desc:
 */
public class ResponseResult implements Serializable {
    private static final long serialVersionUID = -8350138240638924493L;

    /**
     * 响应状态
     */
    private String status;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private Object data;

    public ResponseResult() {
    }

    public ResponseResult(Object data) {
        this.status = "200";
        this.message = "success";
        this.data = data;
    }

    public ResponseResult(String status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public ResponseResult(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static ResponseResult result(String code, String message, Object data) {
        return new ResponseResult(code, message, data);
    }

    public static ResponseResult success() {
        return new ResponseResult(null);
    }

    public static ResponseResult fail() {
        return new ResponseResult("500", "fail");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
