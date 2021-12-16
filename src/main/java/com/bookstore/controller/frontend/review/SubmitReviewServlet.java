package com.bookstore.controller.frontend.review;

import com.bookstore.service.ReviewServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/submit_review")
public class SubmitReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SubmitReviewServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReviewServices reviewServices = new ReviewServices(request, response);
        reviewServices.submitReview();
    }

}