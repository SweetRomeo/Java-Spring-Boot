import java.sql.*;
import java.util.Scanner;

public class Student {
    private int id;
    private int age;
    private String name;
    private String gender;
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    private String addStudentSql;
    private java.util.Scanner scanner = new java.util.Scanner(System.in);

    public Student() {
    }

    public Student(int id, int age, String name, String gender) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public void connectDatabase(String url, String user, String pass) {
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Exception caught: " + e);
            e.printStackTrace();
        }
    }

    public void executeQuery(String loadStudentSql) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(loadStudentSql);
            //resultSet.next();
        } catch (SQLException e) {
            System.out.println("Exception caught: " + e);
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() throws SQLException {
        return resultSet.getString("sname");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
        System.out.println("Connection closed");
    }

    @Override
    public String toString() {
        try {
            return "Student{" +
                    "id=" + resultSet.getInt(1) +
                    ", age=" + resultSet.getInt(2) +
                    ", name='" + resultSet.getString(3) + '\'' +
                    ", gender='" + resultSet.getString(4) + '\'' +
                    '}';
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void printStudentInfo() throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " "
                    + resultSet.getString(3) + " " + resultSet.getString(4));
        }
    }

    public void addStudent() throws SQLException {
        System.out.println("Enter student id: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter student age: ");
        int studentAge = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter student gender: ");
        String studentGender = scanner.nextLine();
        String addStudentSql = "insert into student values (" + studentId + "," + studentAge + ",\' " + studentName + "\',\' " + studentGender + "\')";
        statement = connection.createStatement();
        statement.execute(addStudentSql);
    }
}
