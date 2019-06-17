package cn.edu.gdpt.androiddemo;

public class ListViewInfo {
    private int img_logo;
    private String title;
    private String content;
    private String rate;

    public ListViewInfo(int img_logo, String title, String content, String rate) {
        this.img_logo = img_logo;
        this.title = title;
        this.content = content;
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getImg_logo() {
        return img_logo;
    }

    public void setImg_logo(int img_logo) {
        this.img_logo = img_logo;
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
}
