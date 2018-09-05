package com.mkyong.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientGet {

	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/RESTfulExample/rest/json/metallica/get");

			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

        public String consultarServicio() {
                String respuesta = null;
                String url = "";
		try {

			Client client = Client.create();

                        String servicio = System.getenv("REST_SERVICE_NAME");
                        url = ("http://" + servicio + "/SpringRestfulWebServicesWithJSONExample/countries");
                        System.out.println("URL: " + url);
			WebResource webResource = client.resource("http://" + servicio + "/SpringRestfulWebServicesWithJSONExample/countries");

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				respuesta = ("Oops, Parece que se alcanza el servicio " + servicio + " : HTTP error code : " + response.getStatus());
			}

			respuesta = response.getEntity(String.class);

			System.out.println("Respuesta recibida .... \n");
			System.out.println(respuesta);

		} catch (Exception e) {
                        System.out.println("URL: " + url);
			e.printStackTrace();
		} finally {
                   return respuesta;
                }
        }

}
