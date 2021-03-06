package clases;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CancelacionGratuita extends PoliticaCancelacion{


	//Cancelación gratuita hasta 10 días antes de la fecha de inicio de la
	//ocupación y luego abona el equivalente a dos días de reserva
	
	@Override
	public double valor(Reserva reserva) {
		double monto = 0;
		long diasReserva = ChronoUnit.DAYS.between(reserva.getComienzo(), reserva.getFin());
		long diferencia = ChronoUnit.DAYS.between(LocalDate.now(), reserva.getComienzo());
		if(diferencia < 10) {
			monto = (reserva.getPrecio() / diasReserva) * 2;
		}
		return monto;
	}


}
