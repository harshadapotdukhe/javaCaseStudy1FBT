package com.bookmanagement.bm;

public class Book {
	private int id;
    private String name;
    private String author;
    private String category;
    private float price;
    private float rating;

    // Constructor
    public Book(int id, String name, String author, String category, float price, float rating) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public float getPrice() { return price; }
    public float getRating() { return rating; }

    public void setPrice(float price) { this.price = price; }
    public void setRating(float rating) { this.rating = rating; }

    @Override
    public String toString() {
        return String.format("%-10d%-30s%-25s%-20s%-10.2f%-10.1f", id, name, author, category, price, rating);
    }
}
