import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author shkstart
 * @create 2019-08-10 12:51
 */
public class JDBCDemo1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///dt81","root","1024");
            String sql = "select * from userti";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getObject("id") + "\t" +
                        rs.getObject("username"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}
