import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Hawaii_TAT_GC_CSV  { 
		
	public static void main(String s[]) {
		ArrayList<Booking> mybookings = new ArrayList<Booking>();
		UserInput myinput = new UserInput();
		
		boolean done = false;
		while (!done) {
			boolean choice_enter_booking = myinput.GetMainMenuChoice();
			if (choice_enter_booking) {
				Booking mybooking = myinput.GetBooking();
				if (mybooking != null)
					mybookings.add(mybooking);
			}
			else
				done = true;
			
		}
		
		//final processing
		
    }//main
}//class

 