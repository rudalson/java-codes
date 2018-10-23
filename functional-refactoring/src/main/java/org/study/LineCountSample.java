package org.study;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineCountSample {

    private static long countLegacy(String searchWord, String path) throws IOException {
        long count = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains(searchWord)) {
                count++;
            }
        }

        return count;
    }

    private static long count8Style(String searchWord, String path) throws IOException {
        return Files.lines(Paths.get(path))
                .filter(line -> line.contains(searchWord))
                .count();
    }

    public static void main(String[] args) throws IOException {

        String searchWord = "localhost";
        String path = "/private/etc/hosts";

        long count = countLegacy(searchWord, path);

        System.out.printf("Legacy: The word %s occurred %d times\n", searchWord, count);

        count = count8Style(searchWord, path);

        System.out.printf("8Style: The word %s occurred %d times\n", searchWord, count);
    }
}
