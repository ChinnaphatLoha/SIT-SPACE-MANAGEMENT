package sit.int202.sitspace.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AllDataServlet", value = "/all-data")
public class AllDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ถ้ายังไม่มี Session จะ return เป็น null
        HttpSession session = request.getSession(false);
        // ถ้าไม่มี Session หรือ attribute "allStudent" ใน Session ให้ set message ตามด้านล่าง
        if (session == null || session.getAttribute("allStudent") == null) {
            request.setAttribute("message", "ยังไม่มีข้อมูลนักเรียนในระบบ");
        }
        getServletContext().getRequestDispatcher("/AllData.jsp").forward(request, response);
    }
}
