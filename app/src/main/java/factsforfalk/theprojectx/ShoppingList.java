package factsforfalk.theprojectx;

import android.graphics.Color;

import java.util.ArrayList;

public class ShoppingList {

    private Integer id;
    private String name;
    private String description; // optional
    private Integer color; // optional
    private Integer countArticles; // optional

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

    public static ArrayList<ShoppingList> createShoppingLists() {
        ArrayList<ShoppingList> shoppingLists = new ArrayList<ShoppingList>();

        shoppingLists.add(new ShoppingList(1, "Netto", null, null, 5));
        shoppingLists.add(
                new ShoppingList(2, "Einläufe Wochenende", "Diese Liste enthält das was im Titel drin steht.", null, 5));
        shoppingLists.add(new ShoppingList(3, "Geburtstagsgeschenke", null, null, 5));
        shoppingLists.add(new ShoppingList(4, "TODO", "Hier muss ich noch was hinzufügen", null, 5));
        shoppingLists.add(new ShoppingList(5, "behindert", "Nur Spaß... ist nicht ernst gemeint", null, 5));
        shoppingLists.add(new ShoppingList(6, "Was geht ab", null, null, 5));
        shoppingLists.add(new ShoppingList(7, "Dumm oder so?", null, null, 5));
        shoppingLists.add(new ShoppingList(8, "Test", "bestanden", null, 5));
        shoppingLists.add(new ShoppingList(9, "123 bin dabei", null, null, 5));
        shoppingLists.add(new ShoppingList(10, "Kaufland", null, null, 5));

        return shoppingLists;
    }
}
