package Example.company;

import Example.company.employees.Employee;
import Example.company.employees.ITSpecialist;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Department> departments = new ArrayList<>();

    private List<Employee> employees = new ArrayList<>();

    public <T extends Employee> void addDepartment(Department<T> dep) {
        departments.add(dep);
        List<T> employeeList = dep.getEmployees();
        giveRise(employeeList);
        this.employees.addAll(employeeList);
    }

    // ? extends Class - wildcard ограничен сверху. Все подтипы класса
    private void giveRise(List<? extends Employee> employeeList) {
        for (Employee employee : employeeList) {
            float rise = employee.getSalary() * 0.2f;
            employee.setSalary(employee.getSalary() + rise);
        }
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    // ? - неограниченый wildcard. На практике в реальных проектах не используется.
    public void print(List<?> list) {
        System.out.println("Size " + list.size());
        System.out.println(list);
    }
    // ? super Class - wildcard ограничен снизу.
    public void addToItEmployees(List<? super ITSpecialist> list) {
        list.add(new ITSpecialist("Joe",3500.0f));
    }

    @Override
    public String toString() {
        return "Company{" +
                "departments=" + departments +
                ", employees=" + employees +
                '}';
    }

}
