package com.task.cep.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.cep.event.ViruslogEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class JsonFileParser {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(JsonFileParser.class);

    public List<ViruslogEvent> getWebEvents() throws IOException {

        //read json file data to String
        String fileName = "C:\\Users\\Pooja Patel\\IdeaProjects\\SIEM_CEP_new\\weblog.txt";

        byte[] jsonData = Files.readAllBytes(Paths.get(fileName));

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        List<ViruslogEvent> weblogEventList = objectMapper.readValue(jsonData, new TypeReference<List<ViruslogEvent>>() {
        });
        LOG.info("Reading " + weblogEventList.size() + " events from the " + fileName);
        return weblogEventList;
  }

    public List<ViruslogEvent> getSymEvents() throws IOException {
        String fileName1 = "C:\\Users\\Pooja Patel\\IdeaProjects\\SIEM_CEP_new\\symlog.txt";
        byte[] jsonData1 = Files.readAllBytes(Paths.get(fileName1));
        ObjectMapper objectMapper = new ObjectMapper();
        List<ViruslogEvent> symlogEventList = objectMapper.readValue(jsonData1, new TypeReference<List<ViruslogEvent>>() {
        });

        LOG.info("Reading " + symlogEventList.size() +" events from the " +fileName1);
        return symlogEventList;

    }
}
