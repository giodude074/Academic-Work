import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Lockdown {

	public static void main(String[] args) {

		System.out.println("Receiving Signal from Validator ... ");

		Scanner input=new Scanner(System.in);

		System.out.println("Signal Status:" );
		Boolean Status=input.nextBoolean();
		System.out.println("Processing Signal Status ... " );

		process();

		System.out.println("Signal Message:" );
		String Message=input.next();
		System.out.println("Processing Signal Message ... " );

		process();	


		System.out.println("Signal Source:" );
		String Source= input.nextLine();
		Source= input.next();
		System.out.println("Processing Signal Source ... " );

		process();

		ValidationStatus Signal= receive(new ValidationStatus(Status,Message,Source));

		if(Signal.equals(null)){
			System.out.println("False Alarm");
		}
		else{
			InitiateLockDown(Signal.Message);
		}			

	}


	public static void process(){
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException Ex){

		}	
	}
	private static ValidationStatus receive(ValidationStatus signal){

		if(signal.Validation){
			return signal;
		}
		else{
			return null;
		}

	}

	public static void InitiateLockDown(String Message){
		System.out.println("Received Signal: "+Message);

		int  EntranceCount = 1;
		while(EntranceCount<=4){
			try{
				Thread.sleep(2000);
			}
			catch(InterruptedException Ex){

			}
			System.out.println("Shutting Window "+EntranceCount+" ...");
			EntranceCount++;
		}

		EntranceCount = 1;

		while(EntranceCount<=3){
			try{
				Thread.sleep(2000);
			}
			catch(InterruptedException Ex){

			}
			System.out.println("Shutting Door "+EntranceCount);
			EntranceCount ++;
		}

		System.out.println("House on LockDown Mode: Authority has been alerted.");
		System.out.println("Confirmation sent to the Central Control.");

	}
}
