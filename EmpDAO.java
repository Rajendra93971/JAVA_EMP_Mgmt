package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDAO {

    public static boolean addEmployee(Employee e) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Employee VALUES (?, ?, ?)");
        ps.setInt(1, e.getEmpNO());
      ps.setString(2, e.getEmpName());

        ps.setDouble(3, e.getEmpSal());
        int result = ps.executeUpdate();
        return result == 1;
    }

    public static Employee findEmployeeById(int empno) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee WHERE Empno=?");
        ps.setInt(1, empno);
        ResultSet rs = ps.executeQuery();
        Employee e = null;
        if (rs.next()) {
            e = new Employee();
            e.setEmpNO(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
        }
        return e;
    }

    public static ArrayList<Employee> getAllEmployee() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Employee");
        ArrayList<Employee> empList = new ArrayList<>();
        while (rs.next()) {
            Employee e = new Employee();
            e.setEmpNO(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
            empList.add(e);
        }
        return empList;
    }
}
