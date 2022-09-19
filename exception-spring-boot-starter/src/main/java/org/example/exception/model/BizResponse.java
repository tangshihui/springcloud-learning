package org.example.exception.model;

import java.io.Serializable;

public class BizResponse<T> implements Serializable {
    private class Meta {
        private String metaCode;
        private String publicMessage;

        public Meta(String metaCode, String publicMessage) {
            this.metaCode = metaCode;
            this.publicMessage = publicMessage;
        }

        public String getMetaCode() {
            return metaCode;
        }

        public void setMetaCode(String metaCode) {
            this.metaCode = metaCode;
        }

        public String getPublicMessage() {
            return publicMessage;
        }

        public void setPublicMessage(String publicMessage) {
            this.publicMessage = publicMessage;
        }
    }
    public BizResponse(String metaCode, String publicMessage, T data) {
        this.meta = new Meta(metaCode, publicMessage);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    private Meta meta;

    private T data;


    public static <T> BizResponse<T> OK(T d){
        return new BizResponse<T>("OK","",d);
    }


    public static <T> BizResponse<T> Error(String message){
        return new BizResponse<T>("A01001",message,null);
    }
}
