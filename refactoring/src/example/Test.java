package example;

public class Test {
	private static String result;
	public static void main(String args[]) {	
		Customer aCustomer = new Customer("Tom");
		aCustomer.addRental(new Rental(new Movie("Star Wars", 0), 30));
		aCustomer.addRental(new Rental(new Movie("Frozen", 2), 10));
		aCustomer.addRental(new Rental(new Movie("Transformer", 1), 60));
		aCustomer.addRental(new Rental(new Movie("Star Trek", 0), 5));
		aCustomer.addRental(new Rental(new Movie("God of Rings", 1), 15));
		result = aCustomer.statement();
		System.out.println(result);
	}
}
