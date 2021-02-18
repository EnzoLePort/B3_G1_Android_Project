package fr.epsi.ourapplicationb3g1_ase;

import org.json.JSONObject;

public class Products {

    private String name;
    private String description;
    private String picture_url;

    public Products(JSONObject o){
        name = o.optString("name","");
        description = o.optString("description","");
        picture_url = o.optString("picture_url","");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture_url() {
        return picture_url;
    }
    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }
}
