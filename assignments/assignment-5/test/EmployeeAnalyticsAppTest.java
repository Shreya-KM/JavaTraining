import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class EmployeeAnalyticsAppTest {
	private List<Employee> employees;
	
	@BeforeEach
	void setUp() {
		employees = EmployeeAnalyticsApp.getEmployees();
	}
	
	@Test
	void findEmployeeByIdLoopShouldFindRavi() {
		assertEquals("Ravi", EmployeeAnalyticsApp.findEmployeeByIdLoop(employees, 101).getName());
	}
	
	@Test
	void findEmployeeByIdStreamShouldFindPriya() {
		assertEquals("Priya", EmployeeAnalyticsApp.findEmployeeByIdStream(employees, 102).get().getName());
	}
	
	@Test
	void uniqueLocationsShouldHaveFiveLocations() {
		assertEquals(5, EmployeeAnalyticsApp.getUniqueLocations(employees).size());
	}
	
	@Test
	void salaryFilterShouldReturnSixEmployees() {
		assertEquals(6, EmployeeAnalyticsApp.getEmployeesWithSalaryGreaterThan(employees, 80000).size());
	}
	
	@Test
	void itDepartmentShouldHaveSixEmployees() {
		assertEquals(6, EmployeeAnalyticsApp.getEmployeesByDepartment(employees, "IT").size());
	}
	
	@Test
	void employeeCountShouldBeFifteen() {
		assertEquals(15, EmployeeAnalyticsApp.getEmployeeCount(employees));
	}
	
	@Test
	void highestPaidEmployeeShouldBeMeena() {
		assertEquals("Meena", EmployeeAnalyticsApp.getHighestPaidEmployee(employees).get().getName());
	}
	
	@Test
	void totalSalaryShouldBeCalculated() {
		assertEquals(1168000, EmployeeAnalyticsApp.getTotalSalary(employees), 0.001);
	}
	
	@Test
	void partitionShouldSeparateExperiencedEmployees() {
		assertEquals(6, EmployeeAnalyticsApp.partitionByExperience(employees).get(true).size());
	}
	
	@Test
	void employeeMapShouldFindVijay() {
		Map<Integer, Employee> employeeMap = EmployeeAnalyticsApp.getEmployeeMap(employees);
		assertEquals("Vijay", EmployeeAnalyticsApp.findEmployee(employeeMap, 113).getName());
	}
	
	@Test
	void findEmployeeByNameShouldHandleFoundAndNotFound() {
		assertTrue(EmployeeAnalyticsApp.findEmployeeByName(employees, "Ravi").isPresent());
		assertFalse(EmployeeAnalyticsApp.findEmployeeByName(employees, "Unknown").isPresent());
	}
	
	@Test
	void highestPaidITEmployeeShouldNotBeNull() {
		assertNotNull(EmployeeAnalyticsApp.getHighestPaidITEmployee(employees).orElse(null));
	}
}




