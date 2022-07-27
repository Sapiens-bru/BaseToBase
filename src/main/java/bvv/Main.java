package bvv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/main/resources/application.properties.txt");

        Map<String,String> properties = new HashMap<>();

        for (String oneline:Files.readAllLines(path)) {
            String[] propPair = oneline.toLowerCase().split("=");
            if (propPair.length==2){
                properties.put(propPair[0].trim(),propPair[1].trim());
            }
        }

        Path outputFile = Paths.get(properties.get("outputfile"));

        Files.createFile(outputFile);

        if (!Files.exists(outputFile)){
             throw new RuntimeException("Output file can not be created");
        }

        Files.write(outputFile, Collections.singleton("test"));

    }
}