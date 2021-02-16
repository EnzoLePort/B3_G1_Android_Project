package fr.epsi.ourapplicationb3g1_ase;

import org.json.JSONObject;

public class Categories {

    private String category_id;
    private String title;
    private String products_url;

    public Categories(JSONObject o){
        category_id = o.optString("category_id","");
        title = o.optString("title","");
        products_url = o.optString("products_url","");
    }

    public String getCategory_id() {
        return category_id;
    }
    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducts_url() {
        return products_url;
    }
    public void setProducts_url(String products_url) {
        this.products_url = products_url;
    }

}
