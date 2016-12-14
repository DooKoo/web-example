package servlets;
import java.sql.*;
/*
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

    }
}
*/
class MyDBConnection {

    private Connection myConnection;
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://us-cdbr-azure-west-b.cleardb.com:3306/example_database";
    //?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

    // Database credentials
    static final String USER = "b4de095158f286";
    static final String PASS = "f838bcb2";

    /** Creates a new instance of MyDBConnection */
    public MyDBConnection() {
        init();
    }

    public void init(){

        try{
//Register JDBC driver
            Class.forName(JDBC_DRIVER);

//Open a connection
            myConnection= DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(Exception e){
            System.out.println("Failed to get connection");
            e.printStackTrace();
        }
    }

    public Connection getMyConnection(){
        return myConnection;
    }

    public void close(ResultSet rs){
        if(rs !=null){
            try{
                rs.close();
            }
            catch(Exception e){}
        }
    }

    public void close(java.sql.Statement stmt){

        if(stmt !=null){
            try{
                stmt.close();
            }
            catch(Exception e){}
        }
    }

    public void destroy(){

        if(myConnection !=null){
            try{
                myConnection.close();
            }catch(Exception e){}
        }
    }

    public void Query(String query){

    }

}