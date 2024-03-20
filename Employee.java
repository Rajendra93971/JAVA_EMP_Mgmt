package empmgmt.pojo;

public class Employee {
    private int empNO;
    private String empName;
    private double empSal;

    // Constructor, getters, setters
    // Constructor
    public Employee() {
    }

    public Employee(int empNO, String empName, double empSal) {
        this.empNO = empNO;
        this.empName = empName;
        this.empSal = empSal;
    }

    // Getters and setters
    public int getEmpNO() {
        return empNO;
    }

    public void setEmpNO(int empNO) {
        this.empNO = empNO;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }
}
