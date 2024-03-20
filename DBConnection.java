package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rajen
 */
public class DBConnection {

    private static Connection conn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully!!!");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "ShubhamSir@123");

            JOptionPane.showMessageDialog(null, "Connected successfully", "Success", JOptionPane.INFORMATION_MESSAGE); // Highlighted error: JOptoinPane -> JOptionPane
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error loading driver", "Driver Error!", JOptionPane.ERROR_MESSAGE); // Highlighted error: JoptionPane -> JOptionPane
            ex.printStackTrace();
            System.exit(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error opening connection", "DB Error!", JOptionPane.ERROR_MESSAGE); // Highlighted error: JoptionPane -> JOptionPane
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public static Connection getConnection() {
        return conn;
    }

    public static void closeConnection() {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Connection closed successfully", "Success", JOptionPane.INFORMATION_MESSAGE); // Highlighted error: JOptoinPane -> JOptionPane
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in closing connection", "DB Error!", JOptionPane.ERROR_MESSAGE); // Highlighted error: JoptionPane -> JOptionPane
            ex.printStackTrace();
        }
    }
}
