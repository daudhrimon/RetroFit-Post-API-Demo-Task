package com.daud.retrofixdemo;

public class Entry {
    private String API;
    private String Description;
    private String Auth;
    private Boolean HTTPS;
    private String Cors;
    private String Link;
    private String Category;

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAuth() {
        return Auth;
    }

    public void setAuth(String auth) {
        Auth = auth;
    }

    public Boolean getHTTPS() {
        return HTTPS;
    }

    public void setHTTPS(Boolean HTTPS) {
        this.HTTPS = HTTPS;
    }

    public String getCors() {
        return Cors;
    }

    public void setCors(String cors) {
        Cors = cors;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
