package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/s")
public class MyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PreparedStatement pst;
        MyDBConnection mdbcon;
        Connection conn;
        try{
            String a = request.getParameter("A");
            String b = request.getParameter("B");
            int c = Integer.parseInt(a) + Integer.parseInt(b);
            String sql="INSERT INTO test(A, B, C, D) " +
                    "VALUES (" + a + ", " + b + ", " + c + ", 0)";
            mdbcon= new MyDBConnection();
            conn=mdbcon.getMyConnection();

            pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
        }catch(SQLException exception){exception.printStackTrace();}
        response.sendRedirect("/test/s");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PreparedStatement pst;
        MyDBConnection mdbcon;
        Connection conn;
        ResultSet rs;
        ArrayList<Data> array = new ArrayList<Data>();
        try{
            String sql="SELECT * FROM test";
            mdbcon= new MyDBConnection();
            conn=mdbcon.getMyConnection();
            pst = conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()) {
                Data data = new Data();
                data.A = rs.getInt("a");
                data.B = rs.getInt("b");
                data.C = rs.getInt("c");
                data.D = rs.getInt("d");
                array.add(data);
            }
            mdbcon.close(rs);
            mdbcon.close(rs);
        }catch(Exception e){e.printStackTrace();}
        request.setAttribute("data", array);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}