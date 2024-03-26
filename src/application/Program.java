package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Reservation: " + reservation);
			
			System.out.print("\n\nDigite as datas atualizadas de reserva: ");
			System.out.print("\nCheck-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			reservation.updateDates(checkIn, checkOut);
			System.out.print("Reservation: " + reservation);
				
		}
		catch(ParseException e) {
			System.out.println("Data informada invalida");
		}
		catch (DomainException e ) {
			System.out.print(e.getMessage());
		}	
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		sc.close();
		
	}

}
