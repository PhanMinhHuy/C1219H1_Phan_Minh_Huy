import models.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListCustomerServlet", urlPatterns = "/ListCustomer")
public class ListCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getListCustomer(request,response);
    }

    public void getListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> listCustomer = new ArrayList<>();

        listCustomer.add(new Customer("Phan Minh Huy", "15/09/1999", "Đà Nẵng", "image/IMG_2852.JPG"));
        request.setAttribute("customer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }
}
