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
	private float  Income;
	private float  Mgmt_fee;
	private float  TAT_1;
	private float  TAT_2;
	private float  GE_1;
	private float  GE_2;
	
	private float  NetIncome;
	
	private float  TAT_Gross_Income;
	private float  GET_Gross_Income;

    private float  TAT;
	private float  GET;

	public Booking() {
	}
	
	public boolean Validate(unit, id, start_date, end_date, income, mgmt_fee, tat_1, tat_2, ge_1, ge_2) {
		Unit = unit.toUpperCase();;
		ID   = id.toUpperCase();
		Start_date = start_date.toUpperCase();
		End_date = end_date.toUpperCase();
		
		try {
			Income = Float.parseFloat(income);
		}
		catch (Exception ex) {
			Income = 0;
			System.out.println("Bad income given please give dollar value!");
			return false;
		}
		
		try {
			Mgmt_fee = Float.parseFloat(mgmt_fee);
		}
		catch (Exception ex) {
			Mgmt_fee = 0;
			System.out.println("Bad management fee given please give dollar value!");
			return false;
		}
		
		try {
			TAT_1 = Float.parseFloat(tat_1);
		}
		catch (Exception ex) {
			TAT_1 = 0;
			System.out.println("Bad TAT 1 given please give dollar value!");
			return false;
		}
		
		try {
			TAT_2 = Float.parseFloat(tat_2);
		}
		catch (Exception ex) {
			TAT_2 = 0;
			System.out.println("Bad TAT 2 given please give dollar value!");
			return false;
		}
		
		try {
			GE_1 = Float.parseFloat(ge_1);
		}
		catch (Exception ex) {
			GE_1 = 0;
			System.out.println("Bad GE 1 given please give dollar value!");
			return false;
		}
		
		try {
			GE_2 = Float.parseFloat(ge_2);
		}
		catch (Exception ex) {
			GE_2 = 0;
			System.out.println("Bad GE 2 given please give dollar value!");
			return false;
		}
		
		TAT_Gross_Income = Income + TAT_1 + TAT_2 + GE_1 + GE_2;
		NetIncome = TAT_Gross_Income - Mgmt_fee;
		
		TAT = TAT_Gross_Income * .1025;
		
		GET_Gross_Income = TAT_Gross_Income * (1.0978875 / .955);
		
		GET = GET_Gross_Income - TAT - TAT_Gross_Income;
		
		return true;
	}
}
