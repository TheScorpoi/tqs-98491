package com.tqs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.ParameterType;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;



import static org.junit.jupiter.api.Assertions.assertEquals;


public class StepDefinitions {

    private Library library = new Library();
    private List<Book> booksList = new ArrayList<>();

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDate iso8601Date(String year, String month, String day){
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    @Given("a book with the title {string}, written by {string}, published in {iso8601Date}")
    public void a_book_with_the_title_written_by_published_in(String title, String author, LocalDate date) {
        library.addBook(new Book(title, author, date));
    }

    @Given("another book with the title {string}, written by {string}, published in {iso8601Date}") 
    public void another_book_with_the_title_written_by_published_in(String title, String author, LocalDate date) {
        library.addBook(new Book(title, author, date));
    }

    @When("the customer searches for books published between {iso8601Date} and {iso8601Date}")
    public void the_customer_searches_for_books_published_between_and(LocalDate from, LocalDate to) {
        booksList = library.findBooks(from, to);    
    }

    @Then("{int} books should have been found")
    public void books_should_have_been_found(Integer booksfounded) {
        assertEquals(booksfounded, booksList.size());
    }

    @Then("Book {int} should have the title {string}")
    public void book_should_have_the_title(Integer int1, String string) {
        assertEquals(string, booksList.get(int1-1).getTitle());
    }

}
