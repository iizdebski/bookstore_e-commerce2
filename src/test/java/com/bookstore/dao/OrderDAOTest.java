package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;
import com.bookstore.entity.OrderDetail;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class OrderDAOTest {

    private static OrderDAO orderDAO;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        orderDAO = new OrderDAO();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        orderDAO.close();
    }


    @Test
    public void testCreateBookOrder() {
        BookOrder order = new BookOrder();
        Customer customer = new Customer();
        customer.setCustomerId(61);

        order.setCustomer(customer);
        order.setFirstName("Peter");
        order.setLastName("Thompson");
        order.setPhone("380667622944");
        order.setAddressLine1("PQR");
        order.setAddressLine2("Dragomanov str.");
        order.setCity("New York");
        order.setState("DC");
        order.setCountry("US");
        order.setPaymentMethod("paypal");
        order.setZipCode("123456");

        Set<OrderDetail> orderDetails = new HashSet<>();
        OrderDetail orderDetail = new OrderDetail();

        Book book = new Book(48);
        orderDetail.setBook(book);
        orderDetail.setQuantity(2);
        orderDetail.setSubTotal(81.92f);
        orderDetail.setBookOrder(order);

        orderDetails.add(orderDetail);

        order.setOrderDetails(orderDetails);
        order.setSubTotal(81.92f);
        order.setTax(6.8f);
        order.setShippingFee(2.0f);
        order.setTotal(90.72f);

        orderDAO.create(order);

        assertTrue(order.getOrderId() > 0);
    }

    /*
    @Test
    public void testUpdateBookOrderDetail() {
        Integer orderId = 44;
        BookOrder order = orderDAO.get(orderId);

        Iterator<OrderDetail> iterator = order.getOrderDetails().iterator();

        while (iterator.hasNext()) {
            OrderDetail orderDetail = iterator.next();
            if (orderDetail.getBook().getBookId() == 48) {
                orderDetail.setQuantity(4);
                orderDetail.setSubtotal(163.84f);
            }
        }
        orderDAO.update(order);

        BookOrder updatedOrder = orderDAO.get(orderId);

        iterator = order.getOrderDetails().iterator();

        int expectedQuantity = 4;
        float expectedSubtotal = 163.84f;
        int actualQuantity = 2;
        float actualSubtotal = 81.96f;

        while (iterator.hasNext()) {
            OrderDetail orderDetail = iterator.next();
            if (orderDetail.getBook().getBookId() == 48) {
                actualQuantity = orderDetail.getQuantity();
                actualSubtotal = orderDetail.getSubtotal();
            }
        }

        assertEquals(expectedQuantity, actualQuantity);
        assertEquals(expectedSubtotal, actualSubtotal, 0.0f);
    }

    /*
    @Test
    public void testGet() {
        Integer orderId = 44;
        BookOrder order = orderDAO.get(orderId);
        System.out.println(order.getFirstName());
        System.out.println(order.getLastName());
        System.out.println(order.getPhone());
        System.out.println(order.getAddressLine1());
        System.out.println(order.getAddressLine2());
        System.out.println(order.getCity());
        System.out.println(order.getState());
        System.out.println(order.getCountry());
        System.out.println(order.getZipCode());
        System.out.println(order.getStatus());
        System.out.println(order.getTotal());
        System.out.println(order.getPaymentMethod());
        System.out.println(order.getSubTotal());
        System.out.println(order.getShippingFee());
        System.out.println(order.getTax());

        assertEquals(1, order.getOrderDetails().size());
    }


/*
    @Test
    public void testCreateBookOrder2() {
        BookOrder order = new BookOrder();
        Customer customer = new Customer();
        customer.setCustomerId(14);

        order.setCustomer(customer);
        order.setRecipientName("Nam Ha Minh");
        order.setRecipientPhone("123456789");
        order.setShippingAddress("123 South Street, New York, USA");

        Set<OrderDetail> orderDetails = new HashSet<>();
        OrderDetail orderDetail = new OrderDetail();

        Book book1 = new Book(43);
        orderDetail.setBook(book1);
        orderDetail.setQuantity(4);
        orderDetail.setSubtotal(148.72f);
        orderDetail.setBookOrder(order);

        orderDetails.add(orderDetail);

        order.setOrderDetails(orderDetails);

        orderDAO.create(order);

        assertTrue(order.getOrderId() > 0);

    }


    @Test
    public void testGetByIdAndCustomerNull() {
        Integer orderId = 10;
        Integer customerId = 99;

        BookOrder order = orderDAO.get(orderId, customerId);

        assertNull(order);
    }

    @Test
    public void testGetByIdAndCustomerNotNull() {
        Integer orderId = 36;
        Integer customerId = 14;

        BookOrder order = orderDAO.get(orderId, customerId);

        assertNotNull(order);
    }

    @Test
    public void testListAll() {
        List<BookOrder> listOrders = orderDAO.listAll();

        for (BookOrder order : listOrders) {
            System.out.println(order.getOrderId() + " - " + order.getCustomer().getFullname()
             + " - " + order.getTotal() + " - " + order.getStatus());
            for (OrderDetail detail : order.getOrderDetails()) {
                Book book = detail.getBook();
                int quantity = detail.getQuantity();
                float subtotal = detail.getSubtotal();
                System.out.println("\t" + book.getTitle() + " - " + quantity + " - " + subtotal);
            }
        }

        assertTrue(listOrders.size() > 0);
    }

    @Test
    public void testUpdateBookOrderShippingAddress() {
        Integer orderId = 32;
        BookOrder order = orderDAO.get(orderId);
        order.setShippingAddress("New Shipping Address");

        orderDAO.update(order);

        BookOrder updatedOrder = orderDAO.get(orderId);

        assertEquals(order.getShippingAddress(), updatedOrder.getShippingAddress());
    }

    @Test
    public void testUpdateBookOrderDetail() {
        Integer orderId = 33;
        BookOrder order = orderDAO.get(orderId);

        Iterator<OrderDetail> iterator = order.getOrderDetails().iterator();

        while (iterator.hasNext()) {
            OrderDetail orderDetail = iterator.next();
            if (orderDetail.getBook().getBookId() == 35) {
                orderDetail.setQuantity(3);
                orderDetail.setSubtotal(120);
            }
        }


        orderDAO.update(order);

        BookOrder updatedOrder = orderDAO.get(orderId);

        iterator = order.getOrderDetails().iterator();

        int expectedQuantity = 3;
        float expectedSubtotal = 120;
        int actualQuantity = 0;
        float actualSubtotal = 0;

        while (iterator.hasNext()) {
            OrderDetail orderDetail = iterator.next();
            if (orderDetail.getBook().getBookId() == 35) {
                actualQuantity = orderDetail.getQuantity();
                actualSubtotal = orderDetail.getSubtotal();
            }
        }

        assertEquals(expectedQuantity, actualQuantity);
        assertEquals(expectedSubtotal, actualSubtotal, 0.0f);

    }

    @Test
    public void testCount() {
        long totalOrders = orderDAO.count();
        assertEquals(5, totalOrders);
    }

    @Test
    public void testListByCustomerNoOrders() {
        Integer customerId = 99;
        List<BookOrder> listOrders = orderDAO.listByCustomer(customerId);

        assertTrue(listOrders.isEmpty());
    }

    @Test
    public void testListByCustomerHaveOrders() {
        Integer customerId = 14;
        List<BookOrder> listOrders = orderDAO.listByCustomer(customerId);

        assertTrue(listOrders.size()>0);
    }


    @Test
    public void testDeleteOrder() {
        int orderId = 32;
        orderDAO.delete(orderId);

        BookOrder order = orderDAO.get(orderId);

        assertNull(order);
    }

    @Test
    public void testListMostRecentSales() {
        List<BookOrder> recentOrders = orderDAO.listMostRecentSales();

        assertEquals(3, recentOrders.size());
    }

     */
}