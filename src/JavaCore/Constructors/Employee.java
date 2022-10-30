package JavaCore.Constructors;

public class Employee {

    private static int id = 1000;

    private int employeeID;

    private String name;

    private String position;

    private int salary;

    private String department;

    public Employee() {
        this("A","B",1);
        System.out.println("Empty constructor");
    }

    public Employee(String name, String position, int salary) {
        this(name,position,salary,"IT");
        System.out.println("Constructor with 3 params");
    }

  private Employee(String name, String position, int salary, String department) {
      employeeID = id++;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.department = department;
      System.out.println("Constructor with 4 params");
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

}
