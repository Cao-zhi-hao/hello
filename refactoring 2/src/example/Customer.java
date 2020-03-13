package example;

import java.util.Vector;
import java.util.Enumeration;

public class Customer {

	private String _name;                    // ����
	private Vector<Rental> _rentals = new Vector<Rental>(); // ����¼

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
		double totalAmount = 0;         // �����ѽ��
		int frequentRenterPoints = 0;   // ���ͻ���
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		
		while(rentals.hasMoreElements()){
			Rental each = (Rental)rentals.nextElement();  //ȡ��һ������¼
			

			// add frequent renter points(�ۼ� ���ͻ���)
			frequentRenterPoints = each.point();
			
			// show figures for this rental(��ʾ�˱��������)
			result += "\t" + each.getMovie().getTitle() + "\t" +
				String.valueOf(each.amountFor()) + "\n";
			
			totalAmount += each.amountFor();
		}
		
		// add footer lines����β��ӡ��
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + 
			" frequent renter points";
		
		return result;
	}
}
