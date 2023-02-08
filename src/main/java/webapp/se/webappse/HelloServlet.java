package webapp.se.webappse;

import java.io.*;
import java.util.Collection;

import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.EmployeeEntity;
import model.EmployeeSessionBean;

@WebServlet(name = "helloServlet", value = "/Controller")
public class HelloServlet extends HttpServlet {

    @EJB
    EmployeeSessionBean employeeSessionBean;

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Collection<EmployeeEntity> employeeEntities = employeeSessionBean.getAllEmployees();
        for (EmployeeEntity emp : employeeEntities) {
            System.out.println("Name -----> " + emp.getLastname());
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

}

