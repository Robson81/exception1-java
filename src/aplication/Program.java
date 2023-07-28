package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	Reservation reservation = new Reservation();
	
	System.out.print("Room number: ");
	int room = sc.nextInt();
	System.out.print("Check-in date (dd/MM/yyyy): ");
	Date checkIn = sdf.parse(sc.next());
	System.out.print("Check-out date (dd/MM/yyyy): ");
	Date checkOut = sdf.parse(sc.next());
	
	if(!checkOut.after(checkIn))
		System.out.println("Error in reservation: Check-out date must be after check-in date");
	else {
		 reservation = new Reservation(room, checkIn, checkOut);
		System.out.println("Reservation: " + reservation);
	}
	System.out.println();
	System.out.println("Enter date to update the reservation: ");
	System.out.print("Check-in date (dd/MM/yyyy): ");
	checkIn = sdf.parse(sc.next());
	System.out.print("Check-out date (dd/MM/yyyy): ");
	checkOut = sdf.parse(sc.next());
	
	Date now = new Date();
	
	if(checkIn.before(now) || checkOut.before(now))
		System.out.println("Error in reservation: Reservation dates for update must be future dates");
	else if(!checkOut.after(checkIn))
		System.out.println("Error in reservation: Check-out date must be after check-in date");
	else {
	reservation.updateDates(checkIn, checkOut);
	reservation.duration();
	System.out.println("Reservation: " + reservation);

	}
	
	
	}

}