package IntegracionDispExt;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import modelo.DispositivoInteligente;

import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Control {
	private static long idCliente = 2l;
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		String serverUrl = "http://localhost:8080";

		System.out.println("== START CONTROL ==");

		while (true) {
			System.out.print("Ingresar comando: ");
			String selection = scanner.nextLine();
			String[] split = selection.split(" ");
			//split[0]: comando
			//split[1]: parámetro (id dispositivo por ahora)

			if (split[0].equals("salir")) {
				break;
			} else if ( split[0].equals("estado") && split[1] != "") {
				HttpResponse<String> response;
				try {
					response = Unirest.post(serverUrl + "/dispositivo/estado").queryString("idDispositivo",split[1])
													                          .queryString("idCliente", String.valueOf(idCliente))
													                          .asString();
					if (response.getStatus() == 200) {
						//JSONParser jsonParser = new JSONParser();
		        		//JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody().toString());	        		
		        		//String estado = (String) jsonObject.get("consumo");
						System.out.println("Estado: "+ response.getBody().toString());
					} else {
						System.out.println(response.getStatus() + "-" + response.getStatusText());
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else if( split[0].equals("consumo") && split[1] != null){
				HttpResponse<JsonNode> response;
				try {              
					response = Unirest.get(serverUrl+"/dispositivo/consumo").queryString("idDispositivo",split[1])
							  						 						.queryString("idCliente", String.valueOf(idCliente))
							  						 						.asJson();
					if (response.getStatus() == 200) {					
						System.out.println("Consumo: "+ response.getBody());
					} else {
						System.out.println(response.getStatus() + "-" + response.getStatusText());
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else if( split[0].equals("apagar") && split[1] != null){
				HttpResponse<String> response;
				try {              
					response = Unirest.post(serverUrl+"/dispositivo/apagar").queryString("idDispositivo",split[1])
							  						 						.queryString("idCliente", String.valueOf(idCliente))
							  						 						.asString();
					if (response.getStatus() == 200) {					
						System.out.println("Dispositivo apagado");
					} else {
						System.out.println(response.getStatus() + "-" + response.getStatusText());
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else if( split[0].equals("encender") && split[1] != null){
				HttpResponse<String> response;
				try {              
					response = Unirest.post(serverUrl+"/dispositivo/encender").queryString("idDispositivo",split[1])
							  						 						  .queryString("idCliente", String.valueOf(idCliente))
							  						 						  .asString();
					if (response.getStatus() == 200) {					
						System.out.println("Dispositivo encendido");
					} else {
						System.out.println(response.getStatus() + "-" + response.getStatusText());
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} 
		}

	}
}