package com.bookstore.controller.frontend.book;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.BookServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/view_category")
public class ViewBooksByCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewBooksByCategoryServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookServices bookServices = new BookServices(request, response);
        bookServices.listBooksByCategory();
    }
}