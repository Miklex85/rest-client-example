package com.mkyong.client;
 
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class ClientServlet extends HttpServlet {

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      JerseyClientGet cliente = new JerseyClientGet();
      String respuesta = cliente.consultarServicio();

      try {
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title> Probando el Joining Project Networks </title></head>");
         out.println("<body>");
         out.println("<h1> Respuesta recibida: " + respuesta + "</h1>");
         out.println("</body></html>");
      } finally {
         out.close();
      }
   }
}
