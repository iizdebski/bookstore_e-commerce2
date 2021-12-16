package com.bookstore.controller.admin.order;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.OrderDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

@WebServlet("/admin/remove_book_from_order")
public class RemoveBookFromOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RemoveBookFromOrderServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        BookOrder order = (BookOrder) session.getAttribute("order");

        Set<OrderDetail> orderDetails = order.getOrderDetails();
        Iterator<OrderDetail> iterator = orderDetails.iterator();

        while(iterator.hasNext()) {
            OrderDetail orderDetail = iterator.next();

            if (orderDetail.getBook().getBookId() == bookId) {
                float newTotal = order.getTotal() - orderDetail.getSubTotal();
                order.setTotal(newTotal);
                iterator.remove();
            }
        }

        String editOrderFormPage = "order_form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(editOrderFormPage);
        dispatcher.forward(request, response);
    }
}