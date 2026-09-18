import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter radius of circle:");
		double radius = scanner.nextDouble();
		displayCircle(radius);
		
		System.out.println("Enter basic salary:");
		double basicSalary = scanner.nextDouble();
		displaySalary(basicSalary);
		
		System.out.println("Enter math marks:");
		double math = scanner.nextDouble();
		System.out.println("Enter science marks:");
		double science = scanner.nextDouble();
		System.out.println("Enter english marks:");
		double english = scanner.nextDouble();
		displayMarks(math, science, english);
		
		System.out.println("Enter number for factorial:");
		int factorialNumber = scanner.nextInt();
		System.out.println("Factorial: " + calculateFactorial(factorialNumber));
		
		System.out.println("Enter number of Fibonacci terms:");
		int terms = scanner.nextInt();
		displayFibonacci(terms);
		
		System.out.println("Enter number to check prime:");
		int number = scanner.nextInt();
		if(isPrime(number)) {
			System.out.println("Number is prime");
		}
		else {
			System.out.println("Number is not prime");
		}
		
		displayPrimeNumbers();
		
		System.out.println("Enter number of rows:");
		int rows = scanner.nextInt();
		displayPyramid(rows);
	}
	
	public static void displayCircle(double radius) {
		double area = Math.PI * radius * radius;
		double perimeter = 2 * Math.PI * radius;
		System.out.println("Area: " + area);
		System.out.println("Perimeter: " + perimeter);
	}
	
	public static void displaySalary(double basicSalary) {
		double da = basicSalary * 10 / 100;
		double hra = basicSalary * 15 / 100;
		double netSalary = basicSalary + da + hra;
		System.out.println("DA: " + da);
		System.out.println("HRA: " + hra);
		System.out.println("Net Salary: " + netSalary);
	}
	
	public static void displayMarks(double math, double science, double english) {
		double total = math + science + english;
		double percentage = total / 3;
		System.out.println("Total: " + total);
		System.out.println("Percentage: " + percentage);
		System.out.println("Grade: " + getGrade(percentage));
	}
	
	public static String getGrade(double percentage) {
		if(percentage > 90) {
			return "A+";
		}
		else if(percentage >= 75) {
			return "A";
		}
		else if(percentage >= 60) {
			return "B";
		}
		else if(percentage >= 50) {
			return "C";
		}
		return "F";
	}
	
	public static int calculateFactorial(int number) {
		int factorial = 1;
		for(int i=1;i<=number;i++) {
			factorial = factorial * i;
		}
		return factorial;
	}
	
	public static void displayFibonacci(int terms) {
		int first = 0;
		int second = 1;
		System.out.println("Fibonacci Series:");
		for(int i=1;i<=terms;i++) {
			System.out.print(first + " ");
			int next = first + second;
			first = second;
			second = next;
		}
		System.out.println();
	}
	
	public static boolean isPrime(int number) {
		if(number <= 1) {
			return false;
		}
		for(int i=2;i<number;i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void displayPrimeNumbers() {
		System.out.println("Prime numbers from 1 to 10000:");
		for(int i=1;i<=10000;i++) {
			if(isPrime(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
	
	public static void displayPyramid(int rows) {
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=rows-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
