package IntegracionDispExt;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import modelo.DispositivoInteligente;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Control {
	private static long idCliente = 3l; 
	private static Scanner scanner;
	private static String serverUrl = "https://gentle-sands-84990.herokuapp.com";
	private static HashMap<String, DispositivoInteligente> mapaDispositivos = new HashMap<String, DispositivoInteligente>();
	private static List<DispositivoInteligente> dispositivos;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		System.out.println("== START CONTROL ==");
		
		actualizarMapa();
		
		while (true) {
			System.out.print("Ingresar comando: ");
			String selection = scanner.nextLine();
			String[] split = selection.split(" ");
			//split[0]: comando
			//split[1]: nombre del dispositivo

			if (split[0].equals("salir")) {
				break;
			} else if ( split[0].equals("estado") && (split[1] != "" || split[1] != null )) {
				HttpResponse<String> response;
				try {
					DispositivoInteligente d = mapaDispositivos.get(split[1]);
					System.out.println("Estado: "+d.getEstado().toString());
				} catch (Exception ex) {
					System.out.println("Dispositivo no reconocido");
				}
			} else if( split[0].equals("consumo") && (split[1] != "" || split[1] != null )){
				try {
				DispositivoInteligente d = mapaDispositivos.get(split[1]);
				System.out.println("Consumo: "+d.getConsumoMensual().toString());
				} catch (Exception ex) {
					System.out.println("Dispositivo no reconocido");
				}
			} else if( split[0].equals("apagar") && (split[1] != "" || split[1] != null )){
				HttpResponse<String> response;
				try {              
					response = Unirest.post(serverUrl+"/dispositivo/apagar").queryString("idDispositivo",mapaDispositivos.get(split[1]).getId().toString())
							  						 						.queryString("idCliente", String.valueOf(idCliente))
							  						 						.asString();
					if (response.getStatus() == 200) {					
						System.out.println("Dispositivo apagado");
						actualizarMapa();
					} else {
						System.out.println(response.getStatus() + "-" + response.getStatusText());
					}

				} catch (Exception ex) {
					System.out.println("Dispositivo no reconocido");
				}
			} else if( split[0].equals("encender") && (split[1] != "" || split[1] != null )){
				HttpResponse<String> response;
				try {              
					response = Unirest.post(serverUrl+"/dispositivo/encender").queryString("idDispositivo",mapaDispositivos.get(split[1]).getId().toString())
							  						 						  .queryString("idCliente", String.valueOf(idCliente))
							  						 						  .asString();
					if (response.getStatus() == 200) {					
						System.out.println("Dispositivo encendido");
						actualizarMapa();
					} else {
						System.out.println(response.getStatus() + "-" + response.getStatusText());
					}

				} catch (Exception ex) {
					System.out.println("Dispositivo no reconocido");
				}
			} else if( split[0].equals("dispositivos") ){
				System.out.print("Dispositivos inteligentes: ");
				for(DispositivoInteligente d:dispositivos) {
					System.out.print(d.getNombre()+"  ");
				}
				System.out.println("");
			} else {
				System.out.println("Comando no reconocido");
			}
			System.out.println();
		}

	}
	
	public static List<DispositivoInteligente> obtenerDispositivosInteligentes(){
		HttpResponse<JsonNode> response;
		List<DispositivoInteligente> dispositivos = null;
		try {              
			response = Unirest.get(serverUrl+"/dispositivosInteligentes").queryString("idCliente", String.valueOf(idCliente))
					  						 						     .asJson();
			if (response.getStatus() == 200) {	
				Type listType = new TypeToken<ArrayList<DispositivoInteligente>>(){}.getType();
				dispositivos = new Gson().fromJson(response.getBody().toString(), listType);
			} else {
				System.out.println(response.getStatus() + "-" + response.getStatusText());
				System.out.println("Usted no tiene dispositivos inteligentes");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dispositivos;
	}
	
	public static void actualizarMapa() {
		dispositivos = obtenerDispositivosInteligentes();
		mapaDispositivos.clear();
		for(DispositivoInteligente d:dispositivos) {
			mapaDispositivos.put(d.getNombre(), d);
		}
	}
}