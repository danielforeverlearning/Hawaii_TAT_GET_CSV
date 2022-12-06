import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Booking {
	private String Unit;
	private String ID;
	private String Start_date;
	private String End_date;
	private double  Income;
	private double  Mgmt_fee;
	private double  TAT_1;
	private double  TAT_2;
	private double  GE_1;
	private double  GE_2;
	
	private double  NetIncome;
	
	private double  TAT_Gross_Income;
	private double  GET_Gross_Income;

    private double  TAT;
	private double  GET;
	
	public void Print() {
		System.out.println("Unit       = " + Unit);
		System.out.println("ID         = " + ID);
		System.out.println("Start_date = " + Start_date);
		System.out.println("End_date   = " + End_date);
		System.out.println("Income     = " + Income);
		System.out.println("Mgmt_fee   = " + Mgmt_fee);
		System.out.println("TAT_1      = " + TAT_1);
		System.out.println("TAT_2      = " + TAT_2);
		System.out.println("GE_1       = " + GE_1);
		System.out.println("GE_2       = " + GE_2);
		System.out.println("--------------------------------------");
		System.out.println("NetIncome        = " + NetIncome);
		System.out.println("TAT_Gross_Income = " + TAT_Gross_Income);
		System.out.println("GET_Gross_Income = " + GET_Gross_Income);
		System.out.println("TAT              = " + TAT);
		System.out.println("GET              = " + GET);
	}
	
	public static boolean ExportCSV(ArrayList<Booking> mybookings) {
		try {
			FileWriter myWriter = new FileWriter("output.csv");
			myWriter.write("UNIT,ID,\"START DATE\",\"END DATE\",TAT_1,TAT_2,GE_1,GE_2,MGMT_FEE,INCOME,NET_INCOME,TAT_Gross_Income,GET_Gross_Income,TAT,GET\n");
			
			for (int ii=0; ii < mybookings.size(); ii++) {
				Booking tempbook = mybookings.get(ii);
				myWriter.write(tempbook.Unit + "," + tempbook.ID + "," + tempbook.Start_date + "," + tempbook.End_date + "," + 
				               tempbook.TAT_1 + "," + tempbook.TAT_2 + "," + tempbook.GE_1 + "," + tempbook.GE_2 + "," +
							   tempbook.Mgmt_fee + "," + tempbook.Income + "," + tempbook.NetIncome + "," +
							   tempbook.TAT_Gross_Income + "," + tempbook.GET_Gross_Income + "," + tempbook.TAT + "," + tempbook.GET + "\n");
			}
			myWriter.close();
			return true;
		}
		catch (IOException ex) {
			System.out.println("class Booking method ExportCSV: An exception occurred!");
			ex.printStackTrace();
			return false;
		}
	}

	public Booking() {
	}
	
	public boolean Validate(String unit, String id, String start_date, String end_date, String income, String mgmt_fee, String tat_1, String tat_2, String ge_1, String ge_2) {
		Unit = unit.toUpperCase();;
		ID   = id.toUpperCase();
		Start_date = start_date.toUpperCase();
		End_date = end_date.toUpperCase();
		
		try {
			Income = Double.parseDouble(income);
		}
		catch (Exception ex) {
			Income = 0;
			System.out.println("Bad income given please give dollar value!");
			return false;
		}
		
		try {
			Mgmt_fee = Double.parseDouble(mgmt_fee);
		}
		catch (Exception ex) {
			Mgmt_fee = 0;
			System.out.println("Bad management fee given please give dollar value!");
			return false;
		}
		
		try {
			TAT_1 = Double.parseDouble(tat_1);
		}
		catch (Exception ex) {
			TAT_1 = 0;
			System.out.println("Bad TAT 1 given please give dollar value!");
			return false;
		}
		
		try {
			TAT_2 = Double.parseDouble(tat_2);
		}
		catch (Exception ex) {
			TAT_2 = 0;
			System.out.println("Bad TAT 2 given please give dollar value!");
			return false;
		}
		
		try {
			GE_1 = Double.parseDouble(ge_1);
		}
		catch (Exception ex) {
			GE_1 = 0;
			System.out.println("Bad GE 1 given please give dollar value!");
			return false;
		}
		
		try {
			GE_2 = Double.parseDouble(ge_2);
		}
		catch (Exception ex) {
			GE_2 = 0;
			System.out.println("Bad GE 2 given please give dollar value!");
			return false;
		}
		
		TAT_Gross_Income = Income + TAT_1 + TAT_2 + GE_1 + GE_2;
		NetIncome = TAT_Gross_Income - Mgmt_fee;
		
		TAT = TAT_Gross_Income * 0.1025;
		
		GET_Gross_Income = TAT_Gross_Income * (1.0978875 / 0.955);
		
		GET = GET_Gross_Income - TAT - TAT_Gross_Income;
		
		return true;
	}
}
