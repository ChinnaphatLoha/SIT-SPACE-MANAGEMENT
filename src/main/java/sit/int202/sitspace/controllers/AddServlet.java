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

@WebServlet(name = "AddServlet", value = "/add-student")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ดึงข้อมูลของ Student จาก request parameter
        int id = Integer.parseInt(request.getParameter("addID"));
        String name = request.getParameter("name");
        double score = Double.parseDouble(request.getParameter("score"));

        // สร้าง AllStudent ขึ้นมาใหม่ ถ้ายังไม่มีใน Session
        HttpSession session = request.getSession();
        AllStudent allStudent = (AllStudent) session.getAttribute("allStudent");
        if (allStudent == null) {
            allStudent = new AllStudent();
            session.setAttribute("allStudent", allStudent);
        }

        // ? เช็คว่ามี id ซำ้กับที่กำลังจะเพิ่ม
        Student existingStudent = allStudent.getStudentById(id);

        // เพิ่ม Student ใน AllStudent แล้ว set status message เพื่อแสดงใน jsp
        if (existingStudent != null) {
            request.setAttribute("message", "There is already a student with the same ID (" + existingStudent.getName() + ")");
        } else {
            int result = allStudent.addStudent(id, name, score);
            if (result == 1) {
                request.setAttribute("message", "Add Successful");
            } else if (result == -1) {
                request.setAttribute("message", "Invalid score. Please enter a score between 0 and 100.");
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/AddRemoveStudent.jsp");
        dispatcher.forward(request, response);
    }
}
