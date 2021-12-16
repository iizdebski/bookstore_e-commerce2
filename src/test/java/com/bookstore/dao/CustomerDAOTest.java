package com.bookstore.dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class CustomerDAOTest  {
    private static CustomerDAO customerDAO;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        customerDAO = new CustomerDAO();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        customerDAO.close();
    }

    /*
    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setEmail("customer@gmail.com");
        customer.setFirstName("Peter");
        customer.setLastName("Drucker");
        customer.setCity("DC Columbia");
        customer.setState("New York");
        customer.setCountry("United States");
        customer.setAddressLine1("100 North Avenue");
        customer.setAddressLine2("Clifton Park");
        customer.setPassword("secret");
        customer.setPhone("245001900");
        customer.setZipcode("9587000");

        Customer savedCustomer = customerDAO.create(customer);

        assertTrue(savedCustomer.getCustomerId() > 0);
    }

    @Test
    public void testGet() {
        Integer customerId = 16;
        Customer customer = customerDAO.get(customerId);

        assertNotNull(customer);
    }

   @Test
    public void testUpdateCustomer() {
        Customer customer = customerDAO.get(16);
        String firstname = "Tommy";
        customer.setFirstName(firstname);
        customer.setPassword("123456");

        Customer updatedCustomer = customerDAO.update(customer);

        assertTrue(updatedCustomer.getFirstName().equals(firstname));
    }

    @Test
    public void testListAll() {
        List<Customer> listCustomers = customerDAO.listAll();

        for (Customer customer : listCustomers) {
            System.out.println(customer.getFirstName());
        }

        assertFalse(listCustomers.isEmpty());
    }

    @Test
    public void testCount() {
        long totalCustomers = customerDAO.count();

        assertEquals(17, totalCustomers);
    }

    @Test
    public void testDeleteCustomer() {
        Integer customerId = 30;
        customerDAO.delete(customerId);
        Customer customer = customerDAO.get(customerId);

        assertNull(customer);
    }

   /*

    @Test
    public void testFindByEmail() {
        String email = "tom@gmail.com";
        Customer customer = customerDAO.findByEmail(email);

        assertNotNull(customer);
    }

    @Test
    public void testCheckLoginSuccess() {
        String email = "janebilly@gmail.com";
        String password = "secret";

        Customer customer = customerDAO.checkLogin(email, password);

        assertNotNull(customer);
    }

    @Test
    public void testCheckLoginFail() {
        String email = "abc@gmail.com";
        String password = "secret";

        Customer customer = customerDAO.checkLogin(email, password);

        assertNull(customer);
    }*/
}