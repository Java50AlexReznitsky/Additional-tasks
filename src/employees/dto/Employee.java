package employees.dto;

import java.time.LocalDate;
import java.time.Period;

public class Employee {
	private long id;
	private String name;
	private LocalDate birthDate;
	private String department;
	private int salary;

	public Employee(long id, String name, LocalDate birthDate, String department, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.department = department;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getDepartment() {
		return department;
	}

	public int getSalary() {
		return salary;
	}
	public int getAge() {
		return Period.between(LocalDate.now(), birthDate).getYears();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", department=" + department
				+ ", salary=" + salary + "]";
	}

}
