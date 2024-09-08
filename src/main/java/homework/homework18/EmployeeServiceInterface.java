package homework.homework18;

public interface EmployeeServiceInterface {
    Employee add(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Employee remove(String firstName, String lastName);
}
