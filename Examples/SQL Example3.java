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

        int sid = 101;
        String sName = "Max";
        int marks = 48;

        String url = "jdbc:postgresql://localhost:5432/Demo";
        String username = "postgres";
        String password = "0000";
        String sql = "insert into student values(?,?,?)";

        Connection con = DriverManager.getConnection(url,username, password);

        PreparedStatement st = con.prepareStatement(sql);

        st.setInt(1,sid);
        st.setString(2,sName);
        st.setInt(3, marks);

        st.execute();
        con.close();
        System.out.println("Connection Closed");
    }
}