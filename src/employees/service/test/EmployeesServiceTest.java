package employees.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import employees.dto.Employee;
import employees.service.EmployeeServiceMapsImpl;

class EmployeesServiceTest {
	EmployeeServiceMapsImpl company;
	Employee e1 = new Employee(111, "Yosi", LocalDate.of(1990, 1, 1), "Development", 15000);
	Employee e2 = new Employee(222, "Simon", LocalDate.of(1985, 2, 2), "Development", 17000);
	Employee e3 = new Employee(333, "Goga", LocalDate.of(1995, 3, 3), "Development", 10000);
	Employee e4 = new Employee(444, "Misha", LocalDate.of(2000, 4, 4), "Development", 12500);

	@BeforeEach
	void setUp() {
		company = new EmployeeServiceMapsImpl();
		company.addEmployee(e1);
		company.addEmployee(e2);
		company.addEmployee(e3);
	}

	@Test
	void addEmployeetest() {
		assertTrue(company.addEmployee(e4));
		assertFalse(company.addEmployee(e4));
	}

	@Test
	void getEmployeeTest() {
		Employee expected = new Employee(111, "Yosi", LocalDate.of(1990, 1, 1), "Development", 15000);
		assertEquals(expected, company.getEmployee(111));
		assertThrowsExactly(NoSuchElementException.class, () -> company.getEmployee(555));

	}

	@Test
	void removeEmployeeTest() {
		Employee expected = new Employee(111, "Yosi", LocalDate.of(1990, 1, 1), "Development", 15000);
		assertEquals(expected, company.removeEmployee(111));
		assertNull(company.removeEmployee(555));

	}

	@Test
	void getEmployeesBySalaryTest() {
		Iterable<Employee> result = company.getEmployeesBySalary(15000, 17000);
		Set<Employee> expectedEmployees = new HashSet<>();
		expectedEmployees.add(e1);
		expectedEmployees.add(e2);
		assertEquals(result,expectedEmployees);
	}

	@Test
	void sizeTest() {
		assertEquals(3, company.size());
		company.removeEmployee(111);
		assertEquals(2, company.size());
	}

}
