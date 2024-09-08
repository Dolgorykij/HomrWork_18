package homework.homework18;
import homework.homework18.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final ArrayList<Employee> employeeList;
    private static final Integer INITIAL_CAPACITY = 5;

    public EmployeeService() {
        this.employeeList = new ArrayList<>(INITIAL_CAPACITY);
        this.employeeList.add(new Employee("Sara","Conor"));
        this.employeeList.add(new Employee("Sara1","Conor1"));
        this.employeeList.add(new Employee("Sara2","Conor2"));
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("данный человек уже есть в списке");
        }   else if (employeeList.size()>INITIAL_CAPACITY) {
            throw new EmployeeStorageIsFullException("Слишком много сотрудников");
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Человек не найден");
        }
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName,  lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Человек не найден");
        }
    }

    @Override
    public List<Employee> workerks() {
        return employeeList;
    }

}
