package com.task.cep.route;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.cep.event.AuthenticationLogEvent;
import com.task.cep.handler.EventHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("authlog")
public class AuthenticationLogRoute {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() throws JsonProcessingException {
        System.out.println("\nReceived GET Request");
        // Generate message
        // Message message = Message.generateExampleMessage();
        System.out.println("Auth logs get request");
        // Serialise Message
        // ObjectMapper mapper = new ObjectMapper();
        // String messageAsJSONstring = mapper.writeValueAsString(message);

        return "Ok";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String createMessage(String messageAsJSONstring) throws JsonParseException, JsonMappingException, IOException {
        System.out.println("\nReceived POST Request with JSON String:\n" + messageAsJSONstring);
        EventHandler evnthndlr = new EventHandler();
        // Deserialise JSON message
        ObjectMapper mapper = new ObjectMapper();
        AuthenticationLogEvent[] authLogObjects = mapper.readValue(messageAsJSONstring, AuthenticationLogEvent[].class);
        System.out.println("Creating Message Object...\n" + authLogObjects);
        /*for(int x=0;  x< authLogObjects.length; x++)
            //evnthndlr.handleAuthlog(authLogObjects[x]); */
        return "OK";
    }
}
