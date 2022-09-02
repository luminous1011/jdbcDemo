package com.luminous1011.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.HttpJspPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath = "C:\\Users\\luminous\\Desktop\\IAuto\\jdbcDemo\\maven_web\\study-maven\\servlet01\\src\\main\\resources\\img.png";
        String filename = realPath.substring(realPath.lastIndexOf("\\")+1);
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        FileInputStream in = new FileInputStream(realPath);
        int len =0;

        byte[] buffer = new byte[1024*1024];
        ServletOutputStream out = resp.getOutputStream();
        while ((len=in.read(buffer))!=0){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();

        //HttpJspPage
        HttpSession session = req.getSession();
        session.setAttribute("name",1);
        session.invalidate();
        session.removeAttribute("name");
        session.getAttribute("name");
        //HttpJspBase
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
