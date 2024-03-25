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
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva, data de saida antes a data de entrada");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Reservation: " + reservation);
			
			System.out.print("\n\nDigite as datas atualizadas de reserva: ");
			System.out.print("\nCheck-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = sdf.parse("06/06/2018");
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.print("Erro na reserva: as datas de reserva para atualização devem ser datas futuras.");
			}else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva, data de saida antes a data de entrada");
			}	
			else {
			reservation.updateDates(checkIn, checkOut);
			System.out.print("Reservation: " + reservation);
			}
		}
		
		sc.close();
		
	}

}
