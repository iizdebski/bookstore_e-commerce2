package com.bookstore.controller.frontend.order;

import com.bookstore.service.OrderServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/place_order")
public class PlaceOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public PlaceOrderServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderServices orderServices = new OrderServices(request, response);
        orderServices.placeOrder();
    }
}