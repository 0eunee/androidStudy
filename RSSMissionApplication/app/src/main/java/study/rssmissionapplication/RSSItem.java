package study.rssmissionapplication;

import android.graphics.drawable.Drawable;

/**
 * Created by sungju on 2017-07-31.
 */

public class RSSItem {
    private String title;
    private String content;
    private String date;
    private Drawable icon;

    public RSSItem() {}

    public RSSItem(String title, String content, String date, Drawable icon) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
