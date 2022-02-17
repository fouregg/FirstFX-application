package com.example.demo;

public class Book {
    private String nameOfBook;
    private String authorOfBook;
    private String publishingOfHouse;
    private String isbn;
    private String review;
    private String annotationText;
    private String img1;
    private String img2;
    private float rate;

    public Book(String nameOfBook, String authorOfBook, String publishingOfHouse, String isbn, String review, String annotationText, String img1, String img2, float rate) {
        this.nameOfBook = nameOfBook;
        this.authorOfBook = authorOfBook;
        this.publishingOfHouse = publishingOfHouse;
        this.isbn = isbn;
        this.review = review;
        this.annotationText = annotationText;
        this.img1 = img1;
        this.img2 = img2;
        this.rate = rate;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getAuthorOfBook() {
        return authorOfBook;
    }

    public void setAuthorOfBook(String authorOfBook) {
        this.authorOfBook = authorOfBook;
    }

    public String getPublishingOfHouse() {
        return publishingOfHouse;
    }

    public void setPublishingOfHouse(String publishingOfHouse) {
        this.publishingOfHouse = publishingOfHouse;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getAnnotationText() {
        return annotationText;
    }

    public void setAnnotationText(String annotationText) {
        this.annotationText = annotationText;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public void setRate(float rate){
        this.rate = rate;
    }

    public float getRate() {
        return this.rate;
    }
}
