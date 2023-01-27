package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        
        String fileName = "";
        Integer totalWord = 0;

        if (args.length == 0) {
            System.out.println("Please provide a file name.");
        } else {
            fileName = args[0];
        }

        Path path = Paths.get("./" + fileName);
        File file = path.toFile();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            List<String[]> fileContent = new ArrayList<>();
            Map<String,Integer> termFreq = new HashMap<>();

            // preprocess the text
            // process the first line in the first loop
            // process the remaining line in the second loop
            // quit the loop if there are more than one blank line to indicate end of file
            while (null != (line = br.readLine())) {
                //preproces the first line
                String[] textArray = line.replaceAll("[.,:!-(){}'\"\n\t]", "")
                                        .toLowerCase()
                                        .trim()
                                        .split(" ");
                
                totalWord += textArray.length;
                
                for (int i = 0; i < textArray.length; i++) {
                    String text = textArray[i];
                    if (termFreq.keySet().contains(text)) {
                        termFreq.put(text, termFreq.get(text)+1);
                    } else {
                        termFreq.put(text, 1);
                    }
                }
                
                while(null != (line = br.readLine())){
                    
                    textArray = line.replaceAll("[.,:!-(){}'\"\n\t]", "")
                                        .toLowerCase()
                                        .trim()
                                        .split(" ");

                    totalWord += textArray.length;

                    for (int i = 0; i < textArray.length; i++) {
                        String text = textArray[i];
                        if (termFreq.keySet().contains(text)) {
                            termFreq.put(text, termFreq.get(text)+1);
                        } else {
                            termFreq.put(text, 1);
                        }
                    }

                }

            }

            // remove null key
            termFreq.remove("");

            Integer wordCount = totalWord;

            // sort the map by value
            // termFreq.entrySet().stream()
            //                     .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            //                     .limit(10)
            //                     .map(x -> x.getValue()/ (double) wordCount)
            //                     .forEach(System.out::println);

            termFreq.entrySet().stream()
                                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                                .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), (double) Math.round((Double.valueOf(e.getValue())/(double) wordCount)*1000.0)/1000.0))
                                .limit(10)
                                .forEach(System.out::println);

        } catch (IOException ex) {
            ex.getStackTrace();
        }

    }
}