import java.util.Calendar;
import java.util.Scanner;

public class Limousine implements Vehicle{

	@Override
	public double rent(double rent,double days) {
		
		System.out.println("do you need a driver? yes/no");
		Scanner sc=new Scanner(System.in);
		String d=sc.next();
		System.out.println("Do you need a premium package? yes/no");
		String p=sc.next();
		rent=100;
		
		//To consider the current day
		
		Calendar c=Calendar.getInstance();
		int day =c.get(Calendar.DAY_OF_WEEK);
		
		//Conditions for Limousine services on Friday Saturday
		
		if(d.equals("yes")&&p.equals("yes")&&(day==6||day==7)){
			rent=rent+150+75;
			double finalRent=rent+0.4*rent;
			System.out.println("Your rent for Limousine will be: "+ finalRent*days);
			return finalRent;
		}
		else if(d.equals("no")&&p.equals("yes")&&(day==6||day==7)){
			rent=rent+75;
			double finalRent=rent+0.4*rent;
			System.out.println("Your rent rent for Limousine will be: "+ finalRent*days);
			return finalRent;
		}
		else if(d.equals("yes")&&p.equals("no")&&(day==6||day==7)){
			rent=rent+150;
			double finalRent=rent+0.4*rent;
			System.out.println("Your rent rent for Limousine will be: "+ finalRent*days);
			return finalRent;
		}
		
		//Calculate Limousine Services on rest of the days.
		
		else if(d.equals("yes")&&p.equals("yes")&&(day==2||day==3||day==4||day==5)){
			rent=rent+150+75;
			
			System.out.println("Your rent rent for Limousine will be: "+ rent*days);
			return rent;
		}
		else if(d.equals("yes")&&p.equals("no")&&(day==2||day==3||day==4||day==5)){
			rent=rent+150;
			
			System.out.println("Your rent rent for Limousine will be: "+ rent*days);
			return rent;
		}
		else if(d.equals("no")&&p.equals("yes")&&(day==2||day==3||day==4||day==5)){
			rent=rent+75;
			
			System.out.println("Your rent rent for Limousine will be: "+ rent*days);
			return rent;
		}
		
		//Condition for Limousine services on a Sunday
		
		else if(day==1){
			System.out.println("Your rent rent for Limousine will be: "+ rent*days);
			return rent;
		}
		else if(d.equals("no")&&p.equals("no")&&(day==6||day==7)){
			rent=100;
			double finalRent=rent+0.4*rent;
			System.out.println("Your rent rent for Limousine will be: "+ finalRent*days);
			return finalRent;
		}
		else if(d.equals("no")&&p.equals("no")&&(day==2||day==3||day==4||day==5)){
			rent=100;
			
			System.out.println("Your rent rent for Limousine will be: "+ rent*days);
			return rent;
		}
		
		
		
		return 0;
		
		
		
	}
	
	
	
}
