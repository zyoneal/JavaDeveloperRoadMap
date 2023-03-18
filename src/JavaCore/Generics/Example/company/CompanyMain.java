package Example.company;


import Example.company.employees.Accountant;
import Example.company.employees.ITSpecialist;
import Example.company.employees.Manager;

//=====================================WILDCARDING===========================================
public class CompanyMain {

    public static void main(String[] args) {
        Company company = new Company();

        Department <Accountant> accounting = new Department("Accounting", 5);
        Department <Manager> management = new Department("Management", 2);
        Department <ITSpecialist> itGuys = new Department("IT", 10);

        Accountant accountant = new Accountant("Alex",1000.0f);
        ITSpecialist itSpecialist = new ITSpecialist("James",2000.0f);
        Manager manager = new Manager("Michael",4000.0f);

        accounting.addEmployee(accountant);
        management.addEmployee(manager);
        itGuys.addEmployee(itSpecialist);

        company.addDepartment(accounting);
        company.addDepartment(itGuys);
        company.addDepartment(management);
 //       System.out.println(company);

        company.print(company.getDepartments());
        company.print(company.getEmployees());

        company.addToItEmployees(itGuys.getEmployees());
        company.addToItEmployees(company.getEmployees());
    }

}
