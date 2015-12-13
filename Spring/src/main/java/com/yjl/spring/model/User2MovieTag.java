package com.yjl.spring.model;

import java.util.Date;

public class User2MovieTag extends User2MovieTagKey {
    private String tag;

    private Date tagTime;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Date getTagTime() {
        return tagTime;
    }

    public void setTagTime(Date tagTime) {
        this.tagTime = tagTime;
    }
}