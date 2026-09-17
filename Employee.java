abstract class Employee {
    protected String name;
    protected int employeeId;
    protected double basicSalary;

    public Employee(String name, int employeeId, double basicSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
    }

    public abstract double calculateSalary();

    public void displaySalary() {
        System.out.println("ID: " + employeeId + " | Name: " + name +
                " | Type: " + this.getClass().getSimpleName() +
                " | Salary: " + calculateSalary());
    }
}

class Professor extends Employee {
    private double researchAllowance;

    public Professor(String name, int employeeId, double basicSalary, double researchAllowance) {
        super(name, employeeId, basicSalary);
        this.researchAllowance = researchAllowance;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + researchAllowance + (0.20 * basicSalary); // e.g., HRA 20%
    }
}

class LabAssistant extends Employee {
    private double labAllowance;

    public LabAssistant(String name, int employeeId, double basicSalary, double labAllowance) {
        super(name, employeeId, basicSalary);
        this.labAllowance = labAllowance;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + labAllowance + (0.10 * basicSalary);
    }
}

class AdministrativeStaff extends Employee {
    private double specialAllowance;

    public AdministrativeStaff(String name, int employeeId, double basicSalary, double specialAllowance) {
        super(name, employeeId, basicSalary);
        this.specialAllowance = specialAllowance;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + specialAllowance + (0.05 * basicSalary);
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee[] employees = {
            new Professor("Dr. Kumar", 1, 60000, 10000),
            new LabAssistant("Ravi", 2, 25000, 3000),
            new AdministrativeStaff("Meena", 3, 20000, 2000)
        };

        for (Employee e : employees) {
            e.displaySalary(); // polymorphic call
        }
    }
}