
public class LuxuryCar implements Vehicle{

	@Override
	public double rent(double rent,double days) {
		
		MidSizeCar m=new MidSizeCar();
		double mRent=m.rent(rent, days);
		rent = mRent*2;
		//Luxury Car rent is twice than MidsizeCar
		
		System.out.println("Your rent will be: "+ rent*days);
		return rent;
	}
	
	

}
