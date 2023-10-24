package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UploadImagServlet", value = "/UploadImagServlet-servlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class UploadImagServlet extends HttpServlet {
    private static String File_Dicrecory = "D:\\Intellij\\demo\\src\\main\\resources\\Image";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
      //  resp.sendRedirect("View/UploadFile.jsp");
        System.out.println("da log duoc fdfd ham");
        req.getRequestDispatcher("View/UploadFile.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("da log duoc vao ben trong ham");
         try {
             ServletFileUpload servletFileUpload=new ServletFileUpload(new DiskFileItemFactory());
             List fileitemlist ;
//             fileitemlist = servletFileUpload.parseRequest(req);
             Part filepath = req.getPart("photo");
             System.out.println(filepath.getSubmittedFileName());

         }catch (Exception e){
             System.out.println(e.getMessage());
         }
    }

//    private String GetFilename(Part part){
//        String contentdis = part.getHeader("content-disposition");
//        String[] tokens = contentdis.split(";");
//        for (String token: tokens) {
//            if(token.trim().startsWith("filename")){
//                return token.substring(token.indexOf("=") + 2, token.length() - 1);
//            }
//        }
//        return "";
//    }
}
