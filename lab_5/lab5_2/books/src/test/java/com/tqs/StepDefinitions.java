package com.tqs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.time.ZoneOffset;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions {

    private Library library = new Library();
    private List<Book> booksList = new ArrayList<>();
    
    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime iso8601Date(String year, String month, String day){
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),0, 0);
    }

    @Given("a book with the title {string}, written by {string}, published in {iso8601Date}")
    public void a_book_with_the_title_written_by_published_in(String title, String author, LocalDateTime date) {
        Date date_ = Date.from(date.toInstant(ZoneOffset.UTC));
        library.addBook(new Book(title, author, date_));
    }

    @Given("another book with the title {string}, written by {string}, published in {iso8601Date}") 
    public void another_book_with_the_title_written_by_published_in(String title, String author, LocalDateTime date) {
        Date date_ = Date.from(date.toInstant(ZoneOffset.UTC));
        library.addBook(new Book(title, author, date_));
    }

    @When("the customer searches for books published between {int} and {int}")
    public void the_customer_searches_for_books_published_between_and(Integer from, Integer to) throws ParseException {

        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy");
        Date from_ = originalFormat.parse(from.toString());
        Date to_ = originalFormat.parse(to.toString());

        booksList = library.findBooks(from_, to_);
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
