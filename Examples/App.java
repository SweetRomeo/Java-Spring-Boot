import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/demo";
        String user = "postgres";
        String password = "0000";
        String sql = "select * from student";

        try {
            /*
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            System.out.println("Connected to PostgreSQL Database");
            String studentName = rs.getString("sname");
            System.out.println("The name of the Student is : " + studentName);
            conn.close();
            System.out.println("Disconnected from PostgreSQL Database");
            */
            Student student = new Student();
            student.connectDatabase(url, user, password);
            student.executeQuery(sql);
            student.printStudentInfo();
            student.addStudent();
            student.closeConnection();
        }
        catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
