package com.fzm.pro_test;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 字典表
 */
@Document(collection = "news_code")
public class NewsCode {

    /**
     * 编号.
     */
    private String id;

    // 类型
    private byte type;

    // 代码
    private String code;

    // 名称
    private String name;

    private byte status;

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NewsCode{" + "id='" + id + '\'' + ", type=" + type + ", code=" + code + ", name='" + name + '\''
                + ", status=" + status + '}';
    }
}
