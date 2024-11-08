import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
            import package
            load and register
            create connection
            create statement
            execute statement
            process the results
            close
         */

        String url = "jdbc:postgresql://localhost:5432/Demo";
        String username = "postgres";
        String password = "0000";
        String sql = "delete from student where sid = 5";

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,username, password);
        Statement st = con.createStatement();

        st.execute(sql);
        /*
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getInt(2) + " - ");
            System.out.println(rs.getInt(3) + " - ");
        }*/

        con.close();
        System.out.println("Connection Established");

    }
}