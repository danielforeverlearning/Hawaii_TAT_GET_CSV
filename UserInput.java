import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserInput {
	
		enum Choice {
			ENTER_BOOKING,
			EXPORT_CSV,
			EXIT
		}
	
		public UserInput() {
		}
		
		public Choice GetMainMenuChoice() {
			System.out.println("(1) Enter a booking");
			System.out.println("(2) Export all bookings entered to CSV file");
			System.out.println("(3) Exit");
			System.out.println("Please enter choice:");
			Scanner myinput = new Scanner(System.in);
			String line = myinput.nextLine();
			int myint;
			try {
				myint = Integer.parseInt(line);
			}
			catch (Exception ex) {
				myint = 3;
			}
			if (myint == 1)
				return Choice.ENTER_BOOKING;
			else if (myint == 2)
				return Choice.EXPORT_CSV;
			else
				return Choice.EXIT;
		}
		
		public Booking GetBooking() {
			Scanner myinput = new Scanner(System.in);

			System.out.println("Enter unit:");
			String unit = myinput.nextLine();
			
			System.out.println("Enter id:");
			String id = myinput.nextLine();
		
			System.out.println("Enter start date:");
			String start_date = myinput.nextLine();
		
			System.out.println("Enter end date:");
			String end_date = myinput.nextLine();
		
			System.out.println("Enter income:");
			String income = myinput.nextLine();
		
			System.out.println("Enter management fee:");
			String mgmt_fee = myinput.nextLine();
		
			System.out.println("Enter TAT 1:");
			String TAT_1 = myinput.nextLine();
		
			System.out.println("Enter TAT 2:");
			String TAT_2 = myinput.nextLine();
		
			System.out.println("Enter GE 1:");
			String GE_1 = myinput.nextLine();
		
			System.out.println("Enter GE 2:");
			String GE_2 = myinput.nextLine();
			
			Booking mybooking = new Booking();
			boolean good = mybooking.Validate(unit, id, start_date, end_date, income, mgmt_fee, TAT_1, TAT_2, GE_1, GE_2);
			if (good)
				return mybooking;
			else
				return null;
		}
}