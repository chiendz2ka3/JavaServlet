package UploadFile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.Writer;
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name = "UploadFile", value = "/UploadFile-servlet")
public class UploadFile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        System.out.println("=upload//////");
        writer.write("<html><body>");
        writer.write("<form action='UploadFile-servlet' method='POST' >");
        writer.write("<input type='file' name='Upload' />");
        writer.write("<input type='submit' value='Submit' />");
        writer.write("</form>");
        writer.write("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
          try {

          }catch (Exception e){

          }
    }
}
