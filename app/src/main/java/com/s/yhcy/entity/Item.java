package com.s.yhcy.entity;

/**
 * Created by PawN on 2016/9/4.
 */
public class Item {

    private String title;
    private String content;

    public Item(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Item() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
