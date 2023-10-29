package sit.int202.sitspace.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sit.int202.sitspace.models.AllStudent;
import sit.int202.sitspace.models.Student;

import java.io.IOException;

@WebServlet(name = "RemoveServlet", value = "/remove-student")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ดึงข้อมูลของ Student ID จาก request parameter
        int idToRemove = Integer.parseInt(request.getParameter("removeID"));

        // ดึง AllStudent มาจาก Session
        HttpSession session = request.getSession();
        AllStudent allStudent = (AllStudent) session.getAttribute("allStudent");

        // ? เช็คว่าไม่มี id ที่กำลังจะลบ
        Student studentToRemove = allStudent.getStudentById(idToRemove);

        // ลบ Student ใน AllStudent แล้ว set status message เพื่อแสดงใน jsp
        if (studentToRemove != null) {
            allStudent.removeStudent(idToRemove);
            request.setAttribute("message", "Removed student: (" + idToRemove + ") " + studentToRemove.getName());
        } else {
            request.setAttribute("message", "There is no student with ID: " + idToRemove);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/AddRemoveStudent.jsp");
        dispatcher.forward(request, response);
    }

}
