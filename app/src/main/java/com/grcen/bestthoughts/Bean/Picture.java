package com.grcen.bestthoughts.Bean;

import android.util.Log;

public class Picture {
    private String name;
    private String content;
    private String imageId;
    private String iconId;
    private int zannum;
    private int contentnum;
    private int sharenum;

    public Picture(String name,String content,int zannum,int contentnum,int sharenum,String iconId,String imageId){
        this.name = name;
        this.content = content;
        this.zannum = zannum;
        this.contentnum = contentnum;
        this.sharenum = sharenum;
        this.iconId = iconId;
        this.imageId = imageId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public int getZannum() {
        return zannum;
    }

    public void setZannum(int zannum) {
        this.zannum = zannum;
    }

    public int getContentnum() {
        return contentnum;
    }

    public void setContentnum(int contentnum) {
        this.contentnum = contentnum;
    }

    public int getSharenum() {
        return sharenum;
    }

    public void setSharenum(int sharenum) {
        this.sharenum = sharenum;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }
}
