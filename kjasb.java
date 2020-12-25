import javax.xml.transform.Result;
import java.sql.*;

public class DataConnector {
    public static void main(String args[])
    {
        Connection con;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql:http://localhost/phpmyadmin/de2","root", "");
            String sql = "SELECT * FROM dong_gop Where ID = 1  ";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {

                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        System.out.print( rsmd.getColumnName(i) + " : "+ columnValue );
                    }
                }}
            catch (SQLException e ) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }
            System.out.print("Database is connected !");
            //conn.close();
        }
        catch(Exception e)
        {
            System.out.print("Do not connect to DB - Error:"+e);
        }

    }
}