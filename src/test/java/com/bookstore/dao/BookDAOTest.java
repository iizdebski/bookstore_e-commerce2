package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class BookDAOTest {
    private static BookDAO bookDao;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        bookDao = new BookDAO();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        bookDao.close();
    }

   @Test
    public void testUpdateBook() throws ParseException, IOException {
        Book existBook = new Book();
        existBook.setBookId(11);

        Category category = new Category("Java Core");
        category.setCategoryId(12);
        existBook.setCategory(category);

        existBook.setTitle("Effective Java (3rd Edition)");
        existBook.setAuthor("Joshua Bloch");
        existBook.setDescription("New coverage of generics, enums, annotations, autoboxing");
        existBook.setPrice(40f);
        existBook.setIsbn("0321356685");

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date publishDate = dateFormat.parse("05/28/2018");
        existBook.setPublishDate(publishDate);

        String imagePath = "E:\\ProgrammingPreparation\\IdeaProjects\\BookStoreWebsite\\bookstore\\src\\main\\webapp\\images\\EffectiveJava.jpg";

        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        existBook.setImage(imageBytes);

        Book updatedBook = bookDao.update(existBook);

        assertEquals(existBook.getTitle(), "Effective Java (3rd Edition)");
    }

    @Test
    public void testCreateBook() throws ParseException, IOException {
        Book newBook = new Book();

        Category category = new Category("Advanced Java");
        category.setCategoryId(23);
        newBook.setCategory(category);

        newBook.setTitle("Effective Java (2nd Edition)");
        newBook.setAuthor("Joshua Bloch");
        newBook.setDescription("New coverage of generics, enums, annotations, autoboxing");
        newBook.setPrice(38.87f);
        newBook.setIsbn("0321356683");

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date publishDate = dateFormat.parse("05/28/2008");
        newBook.setPublishDate(publishDate);

        String imagePath = "E:\\ProgrammingPreparation\\IdeaProjects\\BookStoreWebsite\\bookstore\\src\\main\\webapp\\images\\EffectiveJava.jpg";
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        newBook.setImage(imageBytes);

        Book createdBook = bookDao.create(newBook);

        assertTrue(createdBook.getBookId() > 0);
    }

    @Test
    public void testCreate2ndBook() throws ParseException, IOException {
        Book newBook = new Book();

        Category category = new Category("Advanced Java");
        category.setCategoryId(11);
        newBook.setCategory(category);

        newBook.setTitle("Angular in Action");
        newBook.setAuthor("Alan Mycroft");
        newBook.setDescription("Angular in Action is a clearly written guide to the new features of Angular");
        newBook.setPrice(36.72f);
        newBook.setIsbn("03213578946");

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Date publishDate = dateFormat.parse("05/28/2019");
        newBook.setPublishDate(publishDate);

        String imagePath = "E:\\ProgrammingPreparation\\IdeaProjects\\BookStoreWebsite\\bookstore\\src\\main\\webapp\\images\\AngularInAction.jpg";
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
        newBook.setImage(imageBytes);

        Book createdBook = bookDao.create(newBook);

        assertTrue(createdBook.getBookId() > 0);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testDeleteBook() {
        Integer bookId = 100;
        bookDao.delete(bookId);

        assertTrue(true);
    }

    @Test
    public void testGetBookFail() {
        Integer bookId = 99;
        Book book = bookDao.get(bookId);
        assertNull(book);
    }

    @Test
    public void testGetBookSuccess() {
        Integer bookId = 2;
        Book book = bookDao.get(bookId);
        assertNotNull(book);
    }

    @Test
    public void testListAll() {
        List<Book> listBooks = bookDao.listAll();

        for (Book aBook : listBooks) {
            System.out.println(aBook.getTitle() + " - " + aBook.getAuthor());
        }

        assertFalse(listBooks.isEmpty());
    }

    @Test
    public void testFindByTitleNotExist() {
        String title = "Angular Action";
        Book book = bookDao.findByTitle(title);

        assertNull(book);
    }

    @Test
    public void testFindByTitleExist() {
        String title = "Angular in Action";
        Book book = bookDao.findByTitle(title);

        System.out.println(book.getAuthor());
        System.out.println(book.getPrice());
        assertNotNull(book);
    }

    @Test
    public void testCount() {
        long totalBooks = bookDao.count();

        assertEquals(2, totalBooks);
    }

    @Test
    public void testDeleteBookSuccess() {
        Integer bookId = 33;
        bookDao.delete(bookId);

        assertTrue(true);
    }

    @Test
    public void testListNewBooks() {
        List<Book> listNewBooks = bookDao.listNewBooks();
        for (Book aBook : listNewBooks) {
            System.out.println(aBook.getTitle() + " - " + aBook.getPublishDate());
        }
        assertEquals(4, listNewBooks.size());
    }

    @Test
    public void testSearchBookInTitle() {
        String keyword = "Java";
        List<Book> result = bookDao.search(keyword);
        for (Book aBook : result) {
            System.out.println(aBook.getTitle());
        }
        assertEquals(4, result.size());
    }

    @Test
    public void testSearchBookInAuthor() {
        String keyword = "Alan";
        List<Book> result = bookDao.search(keyword);
        for (Book aBook : result) {
            System.out.println(aBook.getTitle());
        }
        assertEquals(1, result.size());
    }

    @Test
    public void testSearchBookInDescription() {
        String keyword = "As processors become faster and multiprocessor systems become cheaper";
        List<Book> result = bookDao.search(keyword);
        for (Book aBook : result) {
            System.out.println(aBook.getTitle());
        }
        assertEquals(1, result.size());
    }

    @Test
    public void testListByCategory() {
        int categoryId = 34;

        List<Book> listBooks = bookDao.listByCategory(categoryId);

        assertTrue(listBooks.size() > 0);
    }

    @Test
    public void testCountByCategory() {
        int categoryId = 33;
        long numOfBooks = bookDao.countByCategory(categoryId);

        assertTrue(numOfBooks == 8);
    }

    @Test
    public void testListBestSellingBooks() {
        List<Book> topBestSellingBooks = bookDao.listBestSellingBooks();

        for (Book book : topBestSellingBooks) {
            System.out.println(book.getTitle());
        }
        assertEquals(4, topBestSellingBooks.size());
    }

    @Test
    public void testListMostFavoredBooks() {
        List<Book> topFavoredBooks = bookDao.listMostFavoredBooks();

        for (Book book : topFavoredBooks) {
            System.out.println(book.getTitle());
        }

        assertEquals(4, topFavoredBooks.size());
    }
}