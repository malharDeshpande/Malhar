
public class EconomyCars implements Vehicle{

	@Override
	public double rent(double rent,double days) {
		
		MidSizeCar m=new MidSizeCar();
		double rentM=m.rent(rent, days);
		
		//Rent of EconomyCar is 50% less than rate of MidsizeCar
		rent = 0.5*rentM;
		System.out.println("Your rent for Economy Car will be: "+ rent*days);
		return rent;
	}
	
	
	


}
