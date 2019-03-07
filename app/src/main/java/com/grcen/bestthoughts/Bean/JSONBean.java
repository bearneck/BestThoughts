package com.grcen.bestthoughts.Bean;

import org.json.JSONObject;

import java.util.List;

public class JSONBean {
    private List<SonGson> data;

    public List<SonGson> getData() {
        return data;
    }

    public void setData(List<SonGson> data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "JSONBean [data=" + data + "]";
    }


    public static class SonGson {
        private String type; //文章类型
        private String username;//用户名
        private String header; //头像
        private String text;//内容
        private String uid;//文章号
        private int comment;//评论数
        private int up;//赞
        private int forward;//分享
        private String image;//图片链接
        private String thumbnail;//略缩图链接

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public int getUp() {
            return up;
        }

        public void setUp(int up) {
            this.up = up;
        }

        public int getForward() {
            return forward;
        }

        public void setForward(int forward) {
            this.forward = forward;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        @Override
        public String toString() {
            return "SonGson [username=" + username + ", type=" + type + ", username=" + username + ", header=" + header + ", text=" + text
            + ", uid=" + uid + "comment" + comment + "up" + up + "forward" + forward + "image" + image + "thumbnail" + thumbnail + "]";
        }
    }
}
