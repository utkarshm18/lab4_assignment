import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String empId;
    private String name;
    private int age;
    private double salary;

    public Employee(String empId, String name, int age, double salary) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

class EmployeeTable {
    private List<Employee> employees;

    public EmployeeTable(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> searchByAge(int targetAge) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() == targetAge) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> searchByName(String targetName) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(targetName)) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> searchBySalary(String operator, double targetSalary) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (operator.equals(">") && employee.getSalary() > targetSalary) {
                result.add(employee);
            } else if (operator.equals("<") && employee.getSalary() < targetSalary) {
                result.add(employee);
            } else if (operator.equals(">=") && employee.getSalary() >= targetSalary) {
                result.add(employee);
            } else if (operator.equals("<=") && employee.getSalary() <= targetSalary) {
                result.add(employee);
            }
        }
        return result;
    }
}

public class lab4 {
    public static void main(String[] args) {
        System.out.println("UTKARSH MAURYA(E22CSEU1107)");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("161E90", "Raman", 41, 56000));
        employees.add(new Employee("161F91", "Himadri", 38, 67500));
        employees.add(new Employee("161F99", "Jaya", 51, 82100));
        employees.add(new Employee("171E20", "Tejas", 30, 55000));
        employees.add(new Employee("171G30", "Ajay", 45, 44000));

        EmployeeTable employeeTable = new EmployeeTable(employees);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Search options:");
        System.out.println("1. Age");
        System.out.println("2. Name");
        System.out.println("3. Salary (>, <, <=, >=)");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        List<Employee> result = new ArrayList<>();

        switch (choice) {
            case 1:
                System.out.print("Enter the age to search: ");
                int targetAge = scanner.nextInt();
                result = employeeTable.searchByAge(targetAge);
                break;
            case 2:
                System.out.print("Enter the name to search: ");
                String targetName = scanner.nextLine();
                result = employeeTable.searchByName(targetName);
                break;
            case 3:
                System.out.print("Enter the operator (> or < or >= or <=): ");
                String operator = scanner.nextLine();
                System.out.print("Enter the salary to search: ");
                double targetSalary = scanner.nextDouble();
                result = employeeTable.searchBySalary(operator, targetSalary);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        if (result.isEmpty()) {
            System.out.println("No matching records found.");
        } else {
            System.out.println("Matching records:");
            for (Employee employee : result) {
                System.out.println("Employee ID: " + employee.getEmpId() +
                        ", Name: " + employee.getName() +
                        ", Age: " + employee.getAge() +
                        ", Salary: " + employee.getSalary());
            }
        }
    }
}
