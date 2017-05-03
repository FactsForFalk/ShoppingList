package factsforfalk.theprojectx;

import android.graphics.Color;

public class ShoppingList {

    private Integer id;
    private String name;
    private String description;     //optional
    private Integer color;          //optional
    private Integer countArticles;  //optional


    public ShoppingList(Integer id, String name, String description, Integer color, Integer countArticles) {
        this.id = id;
        this.name = name;
        this.description = description == null ? "" : description;
        this.color = color == null ? Color.WHITE : color;
        this.countArticles = countArticles == null ? 0 : countArticles;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getCountArticles() {
        return countArticles;
    }

    public void setCountArticles(Integer countArticles) {
        this.countArticles = countArticles;
    }
}
