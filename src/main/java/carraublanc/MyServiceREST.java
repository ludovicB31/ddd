package carraublanc;

import POJO.POJO_pays.POJO_pays;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MyServiceREST {


    @GET
    public POJO_pays getPaysByName(String nom_pays) {
        POJO_pays[] output=new POJO_pays[1];
        // Create Client
        Client client = ClientBuilder.newClient();

        WebTarget webTarget
                = client.target("https://restcountries.eu/rest/v2/name/");
        WebTarget paysWebTarget
                = webTarget.path(nom_pays);

        Invocation.Builder invocationBuilder
                = paysWebTarget.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();

        // Status 200 is successful.
        if (response.getStatus() != 200) {
            System.out.println("ERREUR HTTP : " + response.getStatus());
            output=null;

        }
        else {
            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = response.readEntity(String.class);
                output= mapper.readValue(json, POJO_pays[].class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }


            System.out.println("-------------------------------SUCCES APPEL REST COUNTRIE .... \n");
        }
        return output[0];
    }


}
