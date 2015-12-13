package com.yjl.spring.model;

import java.util.Date;

/**
 * Created by shirlies on 15-5-11.
 */

public class Movie {
    private int id;//電影id號，自動遞增
    private String name;//電影名字
    private Date time;//電影上線時間
    private String description;//電影描述
    private String director;//電影導演
    private String writer;//電影編劇
    private String language;//電影語種
    private int mLong;//電影時長
    private double rate;//電影評分，因爲有3.5這類分數，所以用double
    private Date rateTime;//電影評分更新時間
    private long clickCount;//該電影總點擊次數
    private long collectCount;//該電影總收藏次數
    private long likeCount;//該電影總喜歡次數
    private long shareCount;//該電影總的被分享次數

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setRateTime(Date rateTime) {
        this.rateTime = rateTime;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Date getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getLanguage() {
        return language;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getmLong() {
        return mLong;
    }

    public void setmLong(int mLong) {
        this.mLong = mLong;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getRateTime() {
        return rateTime;
    }

    public long getClickCount() {
        return clickCount;
    }

    public void setClickCount(long clickCount) {
        this.clickCount = clickCount;
    }

    public long getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(long collectCount) {
        this.collectCount = collectCount;
    }

    public long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }

    public long getShareCount() {
        return shareCount;
    }

    public void setShareCount(long shareCount) {
        this.shareCount = shareCount;
    }
}
