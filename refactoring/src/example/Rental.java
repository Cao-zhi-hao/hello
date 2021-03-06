package example;

public class Rental {
	private Movie _movie;     // 影片
	private int _daysRented;  // 租期

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie(){
		return _movie;
	}

	double amountFor() {
		double result = 0;
		switch(getMovie().getPriceCode()){ //取得影片出租价格
			case Movie.REGULAR:  // 普通片
				result  += 2;
				if(getDaysRented()>2)
					result += (getDaysRented()-2)*1.5;
				break;
				
			case Movie.NEW_RELEASE:  // 新片
				result += getDaysRented()*3;
				break;
				
			case Movie.CHILDRENS:  // 儿童片
				result += 1.5;
				if(getDaysRented()>3)
					result += (getDaysRented()-3)*1.5;
				break;
		}
		return result;
	}

	int point() {
		int frequentRenterPoints = 0;
		frequentRenterPoints  ++;
		// add bouns for a two day new release rental
		if((getMovie().getPriceCode())==Movie.NEW_RELEASE &&
				getDaysRented()>1)
			frequentRenterPoints ++;
		return frequentRenterPoints;
	}
}
