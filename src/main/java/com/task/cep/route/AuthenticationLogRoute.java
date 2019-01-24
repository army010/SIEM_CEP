package com.task.cep.route;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.task.cep.event.AuthenticationLogEvent;
import com.task.cep.handler.EventHandler;

@Path("authlog")
public class AuthenticationLogRoute {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() throws JsonProcessingException
    {
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
    public String createMessage(String messageAsJSONstring) throws JsonParseException, JsonMappingException, IOException
    {
        System.out.println("\nReceived POST Request with JSON String:\n" + messageAsJSONstring);
        EventHandler evnthndlr = new EventHandler();
        // Deserialise JSON message
        ObjectMapper mapper = new ObjectMapper();
        List<AuthenticationLogEvent> authLogObjects = mapper.readValue(messageAsJSONstring, new TypeReference<List<AuthenticationLogEvent>>() {});
        System.out.println("Creating Message Object...\n" + authLogObjects);
        evnthndlr.handleAuthlog(authLogObjects);
        return "OK";
    }
}
