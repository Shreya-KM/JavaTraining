import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeAnalyticsApp {
	public static void main(String args[]) {
		List<Employee> employees = getEmployees();
		
		System.out.println("All Employees:");
		employees.forEach(employee -> System.out.println(employee));
		System.out.println("Employee 103: " + findEmployeeByIdLoop(employees, 103));
		System.out.println("Unique Locations: " + getUniqueLocations(employees));
		System.out.println("IT Employees: " + getEmployeesByDepartment(employees, "IT"));
		System.out.println("Names: " + getEmployeeNames(employees));
		System.out.println("Highest Paid IT Employee: " + getHighestPaidITEmployee(employees).orElse(null));
		System.out.println("Second Highest Salary Employee: " + getSecondHighestSalaryEmployee(employees).orElse(null));
		System.out.println("Department Salary Report: " + getDepartmentSalaryReport(employees));
		System.out.println("Employee Analytics Dashboard:");
		generateEmployeeReport(employees);
	}
	
	public static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(101, "Ravi", "IT", "Developer", 75000, 5, "Bangalore"));
		employees.add(new Employee(102, "Priya", "HR", "Manager", 85000, 8, "Chennai"));
		employees.add(new Employee(103, "Amit", "IT", "Senior Developer", 95000, 8, "Bangalore"));
		employees.add(new Employee(104, "Sneha", "Finance", "Analyst", 65000, 4, "Mumbai"));
		employees.add(new Employee(105, "Rahul", "IT", "Developer", 70000, 4, "Hyderabad"));
		employees.add(new Employee(106, "Anjali", "HR", "Executive", 55000, 3, "Bangalore"));
		employees.add(new Employee(107, "Kiran", "Finance", "Manager", 90000, 9, "Chennai"));
		employees.add(new Employee(108, "Meena", "IT", "Architect", 125000, 12, "Bangalore"));
		employees.add(new Employee(109, "Arjun", "Sales", "Executive", 60000, 3, "Mumbai"));
		employees.add(new Employee(110, "Divya", "IT", "Developer", 72000, 5, "Pune"));
		employees.add(new Employee(111, "Suresh", "Sales", "Manager", 88000, 10, "Bangalore"));
		employees.add(new Employee(112, "Neha", "HR", "Executive", 58000, 2, "Hyderabad"));
		employees.add(new Employee(113, "Vijay", "IT", "Senior Developer", 100000, 9, "Pune"));
		employees.add(new Employee(114, "Pooja", "Finance", "Analyst", 68000, 5, "Bangalore"));
		employees.add(new Employee(115, "Manoj", "Sales", "Executive", 62000, 4, "Chennai"));
		return employees;
	}
	public static Employee findEmployeeByIdLoop(List<Employee> employees, int id) {
		for(Employee employee:employees) {
			if(employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}
	
	public static Optional<Employee> findEmployeeByIdStream(List<Employee> employees, int id) {
		return employees.stream().filter(employee -> employee.getId() == id).findFirst();
	}
	
	public static Set<String> getUniqueLocations(List<Employee> employees) {
		return employees.stream().map(Employee::getLocation).collect(Collectors.toSet());
	}
	
	public static Map<Integer, Employee> getEmployeeMap(List<Employee> employees) {
		return employees.stream().collect(Collectors.toMap(Employee::getId, employee -> employee));
	}
	
	public static Employee findEmployee(Map<Integer, Employee> employeeMap, int id) {
		return employeeMap.get(id);
	}
	
	public static List<Employee> getEmployeesWithSalaryGreaterThan(List<Employee> employees, double salary) {
		return employees.stream().filter(employee -> employee.getSalary() > salary).collect(Collectors.toList());
	}
	
	public static List<Employee> getEmployeesByDepartment(List<Employee> employees, String department) {
		return employees.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList());
	}
	
	public static List<Employee> getEmployeesByLocation(List<Employee> employees, String location) {
		return employees.stream().filter(employee -> employee.getLocation().equals(location)).collect(Collectors.toList());
	}
	
	public static List<Employee> getExperiencedEmployees(List<Employee> employees) {
		return employees.stream().filter(employee -> employee.getExperience() > 5).collect(Collectors.toList());
	}
	
	public static List<String> getEmployeeNames(List<Employee> employees) {
		return employees.stream().map(Employee::getName).collect(Collectors.toList());
	}
	
	public static Set<String> getUniqueDepartments(List<Employee> employees) {
		return employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
	}
	
	public static List<String> getUppercaseNames(List<Employee> employees) {
		return employees.stream().map(employee -> employee.getName().toUpperCase()).collect(Collectors.toList());
	}
	
	public static List<Employee> sortBySalaryAscending(List<Employee> employees) {
		return employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
	}
	
	public static List<Employee> sortBySalaryDescending(List<Employee> employees) {
		return employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
	}
	
	public static List<Employee> sortByExperienceAscending(List<Employee> employees) {
		return employees.stream().sorted(Comparator.comparing(Employee::getExperience)).collect(Collectors.toList());
	}
	
	public static List<Employee> sortByExperienceDescending(List<Employee> employees) {
		return employees.stream().sorted(Comparator.comparing(Employee::getExperience).reversed()).collect(Collectors.toList());
	}
	
	public static List<Employee> sortByDepartmentAndSalary(List<Employee> employees) {
		return employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Comparator.comparing(Employee::getSalary).reversed())).collect(Collectors.toList());
	}
	
	public static long getEmployeeCount(List<Employee> employees) {
		return employees.stream().count();
	}
	
	public static Optional<Employee> getHighestPaidEmployee(List<Employee> employees) {
		return employees.stream().max(Comparator.comparing(Employee::getSalary));
	}
	
	public static Optional<Employee> getLowestPaidEmployee(List<Employee> employees) {
		return employees.stream().min(Comparator.comparing(Employee::getSalary));
	}
	
	public static double getTotalSalary(List<Employee> employees) {
		return employees.stream().mapToDouble(Employee::getSalary).sum();
	}
	
	public static double getTotalSalaryUsingReduce(List<Employee> employees) {
		return employees.stream().map(Employee::getSalary).reduce(0.0, (salary1, salary2) -> salary1 + salary2);
	}
	
	public static double getAverageSalary(List<Employee> employees) {
		return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
	}
	
	public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
	}
	
	public static Map<String, Long> getCountByDepartment(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	}
	
	public static Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
	}
	
	public static Map<Boolean, List<Employee>> partitionByExperience(List<Employee> employees) {
		return employees.stream().collect(Collectors.partitioningBy(employee -> employee.getExperience() > 5));
	}
	
	public static Optional<Employee> findEmployeeByName(List<Employee> employees, String name) {
		return employees.stream().filter(employee -> employee.getName().equalsIgnoreCase(name)).findFirst();
	}
	
	public static Optional<Employee> getHighestPaidITEmployee(List<Employee> employees) {
		return employees.stream().filter(employee -> employee.getDepartment().equals("IT")).max(Comparator.comparing(Employee::getSalary));
	}
	
	public static Map<String, Optional<Employee>> getHighestPaidEmployeeByDepartment(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
	}
	
	public static List<Employee> getEmployeesAboveAverageSalary(List<Employee> employees) {
		double average = getAverageSalary(employees);
		return employees.stream().filter(employee -> employee.getSalary() > average).collect(Collectors.toList());
	}
	
	public static List<Employee> getTopThreeHighestPaidEmployees(List<Employee> employees) {
		return employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).collect(Collectors.toList());
	}
	
	public static Optional<Employee> getSecondHighestSalaryEmployee(List<Employee> employees) {
		Optional<Double> salary = employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		return salary.flatMap(value -> employees.stream().filter(employee -> employee.getSalary() == value).findFirst());
	}
	
	public static Map<String, DoubleSummaryStatistics> getDepartmentSalaryReport(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summarizingDouble(Employee::getSalary)));
	}
	
	public static List<Employee> getNamesStartingWithA(List<Employee> employees) {
		return employees.stream().filter(employee -> employee.getName().startsWith("A")).collect(Collectors.toList());
	}
	
	public static List<Employee> getEmployeesInSalaryRange(List<Employee> employees, double start, double end) {
		return employees.stream().filter(employee -> employee.getSalary() >= start && employee.getSalary() <= end).collect(Collectors.toList());
	}
	
	public static List<Employee> getExperiencedBangaloreEmployees(List<Employee> employees) {
		return employees.stream().filter(employee -> employee.getLocation().equals("Bangalore") && employee.getExperience() > 5).collect(Collectors.toList());
	}
	
	public static Optional<String> getDepartmentWithHighestAverageSalary(List<Employee> employees) {
		return getAverageSalaryByDepartment(employees).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
	}
	
	public static Optional<String> getLocationWithMaximumEmployees(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getLocation, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
	}
	
	public static List<Employee> getTopThreeITEmployees(List<Employee> employees) {
		return employees.stream().filter(employee -> employee.getDepartment().equals("IT")).sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).collect(Collectors.toList());
	}
	
	public static Set<String> getUniqueDesignations(List<Employee> employees) {
		return employees.stream().map(Employee::getDesignation).collect(Collectors.toSet());
	}
	
	public static Optional<Employee> getLongestServingEmployee(List<Employee> employees) {
		return employees.stream().max(Comparator.comparing(Employee::getExperience));
	}
	
	public static double getTotalITSalary(List<Employee> employees) {
		return employees.stream().filter(employee -> employee.getDepartment().equals("IT")).mapToDouble(Employee::getSalary).sum();
	}
	
	public static boolean isAnyEmployeeEarningMoreThan(List<Employee> employees, double salary) {
		return employees.stream().anyMatch(employee -> employee.getSalary() > salary);
	}
	
	public static boolean isEveryEmployeeExperiencedAtLeast(List<Employee> employees, int experience) {
		return employees.stream().allMatch(employee -> employee.getExperience() >= experience);
	}
	
	public static boolean isEmployeePresent(List<Employee> employees, String name) {
		return employees.stream().anyMatch(employee -> employee.getName().equalsIgnoreCase(name));
	}
	
	public static String getAllEmployeeNames(List<Employee> employees) {
		return employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
	}
	
	public static Optional<Employee> getFirstEmployeeWithSalaryGreaterThan(List<Employee> employees, double salary) {
		return employees.stream().filter(employee -> employee.getSalary() > salary).findFirst();
	}
	
	public static Map<String, List<String>> getDepartmentEmployeeNames(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
	}
	
	public static void generateEmployeeReport(List<Employee> employees) {
		System.out.println("Total Employees: " + getEmployeeCount(employees));
		System.out.println("Average Salary: " + getAverageSalary(employees));
		System.out.println("Highest Salary: " + getHighestPaidEmployee(employees).orElse(null));
		System.out.println("Lowest Salary: " + getLowestPaidEmployee(employees).orElse(null));
		System.out.println("Employee Count By Department: " + getCountByDepartment(employees));
		System.out.println("Employee Count By Location: " + employees.stream().collect(Collectors.groupingBy(Employee::getLocation, Collectors.counting())));
		System.out.println("Experienced Employees: " + getExperiencedEmployees(employees));
		System.out.println("Top 3 Highest Paid Employees: " + getTopThreeHighestPaidEmployees(employees));
		System.out.println("Average Salary By Department: " + getAverageSalaryByDepartment(employees));
	}
}
