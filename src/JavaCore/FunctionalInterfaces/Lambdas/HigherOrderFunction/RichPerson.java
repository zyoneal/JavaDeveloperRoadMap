package Lambdas.HigherOrderFunction;

public class RichPerson {

    private String firstName;

    private String lastName;

    private int salary;

    private int age;

    public RichPerson(String firstName, String lastName, int salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return
                "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", salary=" + salary +
                        ", age=" + age;
    }

}
