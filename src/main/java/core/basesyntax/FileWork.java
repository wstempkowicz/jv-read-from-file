package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File("test2");
        StringBuilder builder = new StringBuilder("");
        // try-with-resources: Scanner will be closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                builder.append(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file.", e);
        }
        String[] words = builder.toString().toLowerCase().split("[\\.\\s+]");
        StringBuilder result = new StringBuilder("");
        int i = 0;
        for (String word : words) {
            if (word.indexOf("w") == 0) {
                if (i == 0) {
                    result.append(word);
                    i++;
                    continue;
                }
                result.append(" ");
                result.append(word);
            }
        }
        String[] wordsWithW = result.toString().split("[\\s+]");
        Arrays.sort(wordsWithW);
        return wordsWithW;
    }
}
