import java.util.Scanner;

public class SUV implements Vehicle{

	@Override
	public double rent(double rent,double days) {
		MidSizeCar m=new MidSizeCar();
		double mRent=m.rent(rent, days);
		//rent of SUV is 50% more than MidsizeCar
		
		rent =1.5*mRent; 
		
		System.out.println("Will you go off-road? yes/no");
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		if(s.equals("yes")){
			
			//If the SUV goes offroad, there's a charge of $15
		   //This charge will be multiplied by days
			
			System.out.println("Your rent for SUV will be: "+ (rent+15)*days);
			
			rent=rent+15;
			
		}
		else{
			System.out.println("Your rent for SUV will be: "+ rent*days);
		}
		return rent;
	}

	
	
	
}
