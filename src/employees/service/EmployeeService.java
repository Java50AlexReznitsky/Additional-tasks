package employees.service;

import employees.dto.Employee;

public interface EmployeeService {
	// returns true on success, false if employee already exists
	boolean addEmployee(Employee empl);

	// returns removed employee, null if employee was not found
	Employee removeEmployee(long id);

	Employee getEmployee(long id);

	Iterable<Employee> getEmployeesByAges(int ageFrom, int ageTo);

	Iterable<Employee> getEmployeesByDepartment(String dedartment);

	Iterable<Employee> getEmployeesBySalary(int salaryFrom, int salaryTo);

	int size();
}
