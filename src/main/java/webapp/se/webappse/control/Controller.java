package webapp.se.webappse.control;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import webapp.se.webappse.model.EmployeeEntity;
import webapp.se.webappse.model.EmployeeSessionBean;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {

    @EJB
    EmployeeSessionBean employeeSessionBean;

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // STEP 1 [BEGIN]

        String loginEnteredInIndexJSP = request.getParameter("loginField");
        String pwdEnteredInIndexJSP = request.getParameter("pwdField");

        String messageForHelloJSP = "Your login is : " + loginEnteredInIndexJSP +" <br>Your password is :" + pwdEnteredInIndexJSP;

        // to allow messageForHelloJSP to be accessible in hello.jsp
        request.setAttribute("messageKey", messageForHelloJSP);

        Vector<EmployeeEntity> employeeEntities = (Vector<EmployeeEntity>) employeeSessionBean.getAllEmployees();

        for (EmployeeEntity e : employeeEntities) {
            System.out.println("Name -------> " + e.getFirstname());
        }


        request.setAttribute("allEmployees", employeeEntities);

        String employeePage = "employee.jsp";
        request.getRequestDispatcher(employeePage).forward(request, response);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

}

