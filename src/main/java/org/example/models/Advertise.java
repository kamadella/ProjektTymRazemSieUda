package org.example.models;

public class Advertise extends AbstractModel{
    private String title;
    private String text;
    private Long idCategory;
    private boolean status;

    public Advertise(String title, String text, Long idCategory, boolean status) {
        this.title = title;
        this.text = text;
        this.idCategory = idCategory;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
