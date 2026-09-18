package assignment4;

public class Assignment4 {
	public static void main(String[] args) {
		Stack<Employee> employees = new Stack<Employee>(3);
		employees.push(new Employee(1, "shreya"));
		employees.push(new Employee(2, "ravi"));
		
		Iterator<Employee> iterator = employees.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println(BracketChecker.isValid("[{a+b} * (c-d)]"));
	}
}
