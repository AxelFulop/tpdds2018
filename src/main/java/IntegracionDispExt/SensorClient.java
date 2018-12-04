package IntegracionDispExt;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.util.Scanner;

public class SensorClient {

	private static Scanner scanner2;
	private static Scanner scanner1;
	private static Long idCliente = 3l;

	public static void main(String[] args) {
		scanner1 = new Scanner(System.in);
		scanner2 = new Scanner(System.in);
		String serverUrl = "https://gentle-sands-84990.herokuapp.com/sensor"; 

		System.out.println("== START SENSOR ==");

		while (true) {

			System.out.print("Ingresar medicion: ");
			Double medicion = scanner1.nextDouble();

			if(!medicion.isNaN()) {
			HttpResponse<String> response;
			try {
				response = Unirest.post(serverUrl).queryString("medicion", medicion.toString())
												  .queryString("idCliente", idCliente.toString())
												  .asString();
				
				if (response.getStatus() == 200) {
					System.out.println("Se ha registrado la medicion");
				} 
				else {
					System.out.println("Respuesta: "+response.getStatus()+" - "+response.getStatusText());
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			}
			
		}
	}
}