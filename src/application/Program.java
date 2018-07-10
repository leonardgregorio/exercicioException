package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.println("Check-in date (dd/mm/yyyy: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/mm/yyyy: ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation.");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation" + reservation);
			System.out.println();

			System.out.println("update reservation: ");
			System.out.println("Check-in date (dd/mm/yyyy: ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/mm/yyyy: ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro, data anterior a hoje");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation.");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation" + reservation);
			}
		}
		sc.close();
	}

}
