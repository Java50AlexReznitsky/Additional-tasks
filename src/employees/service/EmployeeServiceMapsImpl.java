package employees.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import employees.dto.Employee;

// TODO: - implement all unimplemented methods (see description in interface),
//       - use Maps for quick search by different criterion
//       - write tests covering all public methods
public class EmployeeServiceMapsImpl implements EmployeeService {
	private HashMap<Long, Employee> employees = new HashMap<>();
	private TreeMap<Integer, Set<Employee>> ages = new TreeMap<>();
	private TreeMap<Integer, Set<Employee>> salaries = new TreeMap<>();
	private TreeMap<String, Set<Employee>> departments = new TreeMap<>();
	private int size = 0;

	@Override
	public boolean addEmployee(Employee empl) {
		boolean res = false;
		Employee current = employees.get(empl.getId());
		if (current == null) {
			addToAll(empl);
			res = true;
			size++;
		} else if (!current.equals(empl)) {
			res = true;
		}
		addToAll(empl);
		return res;
	}

	private void addToAll(Employee empl) {
		employees.put(empl.getId(), empl);
		ages.computeIfAbsent(empl.getAge(), k -> new HashSet<>()).add(empl);
		salaries.computeIfAbsent(empl.getSalary(), k -> new HashSet<>()).add(empl);
		departments.computeIfAbsent(empl.getDepartment(), k -> new HashSet<>()).add(empl);
	}

	@Override
	public Employee removeEmployee(long id) {
		if (employees.containsKey(id)) {
			Employee toBeRemoved = employees.get(id);
			employees.remove(id);
			Set<Employee> agesSet = ages.get(toBeRemoved.getAge());
			agesSet.remove(toBeRemoved);
			Set<Employee> salariesSet = salaries.get(toBeRemoved.getSalary());
			salariesSet.remove(toBeRemoved);
			Set<Employee> departmentSet = departments.get(toBeRemoved.getDepartment());
			departmentSet.remove(toBeRemoved);
			size--;
			return toBeRemoved;
		}
		return null;
	}

	@Override
	public Employee getEmployee(long id) {
		if (!employees.containsKey(id)) {
			throw new NoSuchElementException();
		}
		return employees.get(id);
	}

	@Override
	public Iterable<Employee> getEmployeesByAges(int ageFrom, int ageTo) {
		// TODO Auto-generated method stub
		return ages.subMap(ageFrom, true, ageTo, true).values().stream().flatMap(Set::stream)
				.collect(Collectors.toSet());
		
	}

	@Override
	public Iterable<Employee> getEmployeesByDepartment(String department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Employee> getEmployeesBySalary(int salaryFrom, int salaryTo) {
		return salaries.subMap(salaryFrom, true, salaryTo, true).values().stream().flatMap(Set::stream)
				.collect(Collectors.toSet());
	}

	@Override
	public int size() {
		return size;
	}
}
