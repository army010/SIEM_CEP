package com.task.cep.route;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.cep.event.AuthenticationLogEvent;
import com.task.cep.event.SyslogEvent;
import com.task.cep.handler.EventHandler;

@Path("syslog")
public class SystemLogRoute {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() throws JsonProcessingException
    {
        System.out.println("\nReceived GET Request System log Request");
        // Generate message
       // Message message = Message.generateExampleMessage();

        // Serialise Message
        ObjectMapper mapper = new ObjectMapper();
        //String messageAsJSONstring = mapper.writeValueAsString(message);

        return "";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String createMessage(String messageAsJSONstring) throws  IOException
    {
        System.out.println("\nReceived POST Request with JSON String:\n" + messageAsJSONstring);
        EventHandler eventHandler = new EventHandler();
        // Deserialise JSON message
        ObjectMapper mapper = new ObjectMapper();
        List<SyslogEvent> sysLogObjects = mapper.readValue(messageAsJSONstring, new TypeReference<List<SyslogEvent>>() {});
        System.out.println("Creating Message Object...\n" + sysLogObjects);
        eventHandler.handleSyslog(sysLogObjects);
        return "OK";
    }
}
