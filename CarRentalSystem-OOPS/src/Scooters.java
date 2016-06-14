
public class Scooters implements Vehicle{

	@Override
	public double rent(double rent,double days) {
	
		System.out.println("Your rent for Scooter will be: "+rent*days);
		return rent;
	}

}
