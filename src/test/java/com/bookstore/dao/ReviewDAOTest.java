package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ReviewDAOTest {

    private static ReviewDAO reviewDAO;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        reviewDAO = new ReviewDAO();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        reviewDAO.close();
    }

   /* @Test
    public void testCreateReview() {
        Review review = new Review();
        Book book = new Book();
        book.setBookId(38);

        Customer customer = new Customer();
        customer.setCustomerId(14);

        review.setBook(book);
        review.setCustomer(customer);

        review.setHeadline("Excellent book!");
        review.setRating(3);
        review.setComment("A comprehensive book about Spring framework!");

        Review savedReview = reviewDAO.create(review);

        assertTrue(savedReview.getReviewId() > 0);
    }

    @Test
      public void testGet() {
        Integer reviewId = 15;
        Review review = reviewDAO.get(reviewId);

        assertNotNull(review);
    }

    @Test
    public void testUpdateReview() {
        Integer reviewId = 15;
        Review review = reviewDAO.get(reviewId);
        review.setHeadline("Excellent book");

        Review updatedReview = reviewDAO.update(review);

        assertEquals(review.getHeadline(), updatedReview.getHeadline());
    }

    @Test
    public void testDeleteObject() {
        fail("Not yet implemented");
    }

    @Test
    public void testListAll() {
        List<Review> listReview = reviewDAO.listAll();

        for (Review review : listReview) {
            System.out.println(review.getReviewId() + " - " + review.getBook().getTitle()
             + " - " + review.getCustomer().getFullname()
             + " - " + review.getHeadline() + " - " + review.getRating());
        }

        assertTrue(listReview.size() > 0);
    }

    @Test
    public void testCount() {
        long totalReviews = reviewDAO.count();
        System.out.println("Total Reviews: " + totalReviews);

        assertTrue(totalReviews > 0);
        }

    @Test
    public void testDeleteReview() {
        int reviewId = 15;
        reviewDAO.delete(reviewId);
        Review review = reviewDAO.get(reviewId);
        assertNull(review);
     }

    @Test
    public void testFindByCustomerAndBookNotFound() {
        Integer customerId = 100;
        Integer bookId = 99;

        Review result = reviewDAO.findByCustomerAndBook(customerId, bookId);

        assertNull(result);
    }

    @Test
    public void testFindByCustomerAndBookFound() { Integer customerId = 14;
        Integer bookId = 35;

        Review result = reviewDAO.findByCustomerAndBook(customerId, bookId);

        assertNotNull(result);
    }

    @Test
    public void testListMostRecent() {
        List<Review> recentRevies = reviewDAO.listMostRecent();

        assertEquals(3, recentRevies.size());
    }*/
}