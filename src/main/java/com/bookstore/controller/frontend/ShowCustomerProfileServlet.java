package com.bookstore.controller.frontend;

import com.bookstore.service.CustomerServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/view_profile")
public class ShowCustomerProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ShowCustomerProfileServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerServices customerServices = new CustomerServices(request, response);
        customerServices.showCustomerProfile();

    }
}