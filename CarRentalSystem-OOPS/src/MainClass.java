import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

public class MainClass {

	private static double totalRent=0;
	
	public static void main(String[] args){
		System.out.println("Welcome to Paradise Rental Agency");
		
		System.out.println("\n"+"Enter the number of vehicles to rent:");
	    Scanner sc=new Scanner(System.in);
	    int a=sc.nextInt();
	    
	    System.out.println("You have entered : "+a+" vehicles");
	    System.out.println("Available Vehicles: "+"\n"+"1. MidsizeCar"+"\n"+"2. EconomyCar"+"\n"+"3. SUV"+"\n"+"4. LuxuryCar"+"\n"+"5. Limousine"+"\n"+"6. Bicycle"+"\n"+"7. Scooter"+"\n"+"8. Motorcycle"+"\n9. JetSkis");
	    for(int i=0;i<a ; i++)
	    {
	    	
	    	System.out.println("Enter the name of vehicle "+i);
	    	String s=sc.next();
	    	System.out.println("You have entered "+s);
	    	
	    	if(s.equals("MidsizeCar")){
	    		MidSizeCar m=new MidSizeCar();
	    		double rent=0;
	    		System.out.println("Enter the no. of days you need the vehicle: ");
		    	double d=sc.nextInt();
		    	System.out.println("You have entered: "+d+"days");
	    		double r=m.rent(rent, d);
	    		totalRent=totalRent+r*d;
	    	}
	    	else if(s.equals("EconomyCar")){
	    		EconomyCars e=new EconomyCars();
	    		System.out.println("Enter the no. of days you need the vehicle: ");
		    	double d=sc.nextInt();
		    	System.out.println("You have entered: "+d+"days");
	    		double r=e.rent(0, d);
	    		totalRent=totalRent+r*d;
	    	}
	    	else if(s.equals("SUV"))
	    	{
	    		SUV suv=new SUV();
	    		System.out.println("Enter the no. of days you need the vehicle: ");
		    	double d=sc.nextInt();
		    	System.out.println("You have entered: "+d+"days");
	    		double r=suv.rent(0, d);
	    		Bicycles b=new Bicycles();
	    		System.out.println("You also get a first bike rental free");
	    		System.out.println("Enter the no. of days you need the bike: ");
		    	double d1=sc.nextInt();
		    	System.out.println("You have entered: "+d1+"days");
	    		b.rent(0, d1);
	    		totalRent=totalRent+r*d;
	    	}
	    	else if(s.equals("LuxuryCar"))
	    	{
	    		LuxuryCar l=new LuxuryCar();
	    		System.out.println("Enter the no. of days you need the vehicle: ");
		    	double d=sc.nextInt();
		    	System.out.println("You have entered: "+d+"days");
	    		double r=l.rent(0, d);
	    		totalRent=totalRent+r*d;
	    	}
	    	else if(s.equals("Limousine")){
	    		Limousine li=new Limousine();
	    		System.out.println("Enter the no. of days you need the vehicle: ");
		    	double d=sc.nextInt();
		    	System.out.println("You have entered: "+d+"days");
	    		double r=li.rent(0, d);
	    		totalRent=totalRent+r*d;
	    	}
	    	
	    	else if(s.equals("Bicycle")){
	    		Bicycles b=new Bicycles();
	    		System.out.println("Enter the no. of days you need the vehicle: ");
		    	double d=sc.nextInt();
		    	System.out.println("You have entered: "+d+"days");
	    		double r=b.rent(10, d);
	    		totalRent=totalRent+r*d;
	    	}
	    	else if(s.equals("Scooter")){
	    		Scooters scooter=new Scooters();
	    		System.out.println("Enter the no. of days you need the vehicle: ");
		    	double d=sc.nextInt();
		    	System.out.println("You have entered: "+d+"days");
	    		double r=scooter.rent(25, d);
	    		totalRent=totalRent+r*d;
	    	}
	    	else if(s.equals("Motorcycle")){
	    		Motorcycles mo=new Motorcycles();
	    		System.out.println("Enter the no. of days you need the vehicle: ");
		    	double d=sc.nextInt();
		    	System.out.println("You have entered: "+d+"days");
	    		double r=mo.rent(0, d);
	    		totalRent=totalRent+r*d;
	    	}
	    	else if(s.equals("JetSkis")){
	    		JetSkis j=new JetSkis();
	    		System.out.println("Enter the number of hours :");
	    		double h=sc.nextDouble();
	    		double r=j.rent(25,h);
	    		totalRent=totalRent+r*h;
	    	}
	    	else{
	    		System.out.println("Enter the vehicle name as per the list above and try running again!");
	    		return;
	    	}
	    	
	    }
	    System.out.println("_______________________________________________________________________");
	    System.out.println("Your Total Rent is: "+totalRent);
	}
}
