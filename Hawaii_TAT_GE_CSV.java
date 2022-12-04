import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Hawaii_TAT_GE_CSV  { 
		
	public static void main(String s[]) {
		ArrayList<Booking> mybookings = new ArrayList<Booking>();
		UserInput myinput = new UserInput();
		
		boolean done = false;
		while (!done) {
			UserInput.Choice choice = myinput.GetMainMenuChoice();
			if (choice == UserInput.Choice.ENTER_BOOKING) {
				Booking tempbook = myinput.GetBooking();
				if (tempbook != null)
					mybookings.add(tempbook);
			}
			else if (choice == UserInput.Choice.EXPORT_CSV) {
				CSV_Handler myhandler = new CSV_Handler();
				myhandler.ExportCSV(mybookings);
			}
			else
				done = true;
			
		}
		
		//final processing
		
    }//main
}//class

 