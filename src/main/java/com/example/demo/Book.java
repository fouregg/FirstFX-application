package com.example.demo;

public class Book {
    private final String nameOfBook;
    private final String authorOfBook;
    private final String publishingOfHouse;
    private final String isbn;
    private final String review;
    private final String annotationText;
    private final String img1;
    private final String img2;
    private final int rate;

    private State state;

    public Book(String nameOfBook, String authorOfBook, String publishingOfHouse, String isbn, String review,
                String annotationText, String img1, String img2, int rate,  String state) {
        this.nameOfBook = nameOfBook;
        this.authorOfBook = authorOfBook;
        this.publishingOfHouse = publishingOfHouse;
        this.isbn = isbn;
        this.review = review;
        this.annotationText = annotationText;
        this.img1 = img1;
        this.img2 = img2;
        this.rate = rate;
        switch (state) {
            case "READ" -> this.state = State.READ;
            case "WILL_READ" -> this.state = State.WILL_READ;
            case "READING" -> this.state = State.READING;
            default -> {
                System.out.println(state);
                this.state = State.WILL_READ;
            }
        }
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public String getAuthorOfBook() {
        return authorOfBook;
    }

    public String getPublishingOfHouse() {
        return publishingOfHouse;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getReview() {
        return review;
    }

    public String getAnnotationText() {
        return annotationText;
    }

    public String getImg1() {
        return img1;
    }

    public String getImg2() {
        return img2;
    }

    public int getRate() {
        return this.rate;
    }

    public State getState() { return this.state; }

    public void setState(State state) { this.state = state; }
}
