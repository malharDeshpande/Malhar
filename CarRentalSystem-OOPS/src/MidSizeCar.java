import java.util.Calendar;

public class MidSizeCar implements Vehicle{

	
	@Override
	public double rent(double rent,double days) {
		
		//To consider the current day
		
		Calendar c=Calendar.getInstance();
		int day=c.get(Calendar.DAY_OF_WEEK);
		
		//Condition of Friday & Saturday of 25% premium
		
		if(day==6||day==7){
			rent =30;
			double premium=rent+(0.25*30);
			System.out.println("Your rent for MidSize Car will be: "+premium*days);
			rent=premium;
			
			
		}
		
		//On Sunday, MidsizeCar has discount of 20%
		
		else if(day==1)
		{
			rent=30;
			double discount= rent-(0.20*30);
			System.out.println("Your rent for MidSize Car will be: "+discount*days);
			rent = discount;
		}
		
		//The base rent of MidsizeCar is 30
		
		else{
			System.out.println("Your rent for MidSize Car will be: "+30*days);
			rent=30;
		}
		return rent;
	}

}
