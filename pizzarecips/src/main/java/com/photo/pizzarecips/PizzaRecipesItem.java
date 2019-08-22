package com.photo.pizzarecips;

public class PizzaRecipesItem {

    private int imageRecours;
    private String title;
    private String decreption;
    private String recipe;

    public PizzaRecipesItem(int imageRecours, String title, String decreption,String recipe) {
        this.imageRecours = imageRecours;
        this.title = title;
        this.decreption = decreption;
        this.recipe=recipe;
    }

    public int getImageRecours() {
        return imageRecours;
    }

    public String getTitle() {
        return title;
    }

    public String getDecreption() {
        return decreption;
    }
    public String getRecipe(){
        return recipe;
    }
}
