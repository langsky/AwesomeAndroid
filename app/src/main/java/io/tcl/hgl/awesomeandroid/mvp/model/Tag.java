package io.tcl.hgl.awesomeandroid.mvp.model;

/**
 * Created by swd1 on 16-12-29.
 */

public class Tag {

    private String title;
    private String url;
    private String topic;

    public Tag() {
        title = "";
        url = "";
        topic = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "title : " + getTitle() + " url: " + getUrl() + " topic: " + getTopic() + '\n';
    }
}
