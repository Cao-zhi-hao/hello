package example;

import java.util.Vector;
import java.util.Enumeration;

public class Customer {

	private String _name;                    // 姓名
	private Vector<Rental> _rentals = new Vector<Rental>(); // 租借记录

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg){
		_rentals.addElement(arg);
	}
	
	public String getName() {
		return _name;
	}

	public String statement() {
		double totalAmount = 0;         // 总消费金额
		int frequentRenterPoints = 0;   // 常客积点
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		
		while(rentals.hasMoreElements()){
			Rental each = (Rental)rentals.nextElement();  //取得一笔租借记录
			

			// add frequent renter points(累加 常客积点)
			frequentRenterPoints = each.point();
			
			// show figures for this rental(显示此笔租借数据)
			result += "\t" + each.getMovie().getTitle() + "\t" +
				String.valueOf(each.amountFor()) + "\n";
			
			totalAmount += each.amountFor();
		}
		
		// add footer lines（结尾打印）
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + 
			" frequent renter points";
		
		return result;
	}
}
