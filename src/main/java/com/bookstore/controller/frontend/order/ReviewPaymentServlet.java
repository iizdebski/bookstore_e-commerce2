package com.bookstore.controller.frontend.order;

import com.bookstore.service.PaymentServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/review_payment")
public class ReviewPaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReviewPaymentServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PaymentServices paymentServices = new PaymentServices(request, response);
        paymentServices.reviewPayment();
    }
}