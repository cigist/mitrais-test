package com.irwan.mitrais.utilities;

import java.io.Serializable;

/**
 * Created by cigist on 15/06/19.
 */
public class RequestResponse implements Serializable {
    private String code;
    private String message;
    private String status;
    private String content;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
