package org.study.mytest;

import java.io.*;
import java.util.*;

public class BigSort {

    public static void main(String[] args) {

        String pushResultFile = "/Users/rudalson/Downloads/direct_push_logs.csv";

        String sandboxFile = "/Users/rudalson/Downloads/sandbox.csv";
//        String csvFile = "/Users/rudalson/Downloads/sandbox.csv";

        String push_result_sorted_file ="/Users/rudalson/Downloads/direct_push_logs(sorted).csv";

        String push_result_not_file ="/Users/rudalson/Downloads/nonexistent_push_logs.csv";

        List<Long> push_results = read(pushResultFile);
        System.out.println("push_results : " + push_results.size());

        List<Long> sandboxes = read(sandboxFile);
        SortedSet<Long> sandSet = new TreeSet<>(sandboxes);
        System.out.println("sandbox count : " + sandboxes.size());

        for (Long token : push_results) {
//            sandboxes.parallelStream().anyMatch(s -> s == token)
            sandSet.remove(token);
        }

        System.out.println("left : " + sandSet.size());

        writeSet(sandSet, push_result_not_file);
    }

    static private List<Long> read(final String inputFilePath) {

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<Long> results = new ArrayList<>();

        try {

            br = new BufferedReader(new FileReader(inputFilePath));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] tokenSeq = line.split(cvsSplitBy);
                results.add(Long.parseLong(tokenSeq[0]));
            }
            Collections.sort(results);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return results;
        }
    }

    static private void write(final List<Long> list, final String outputFilePath) {
        File file = new File(outputFilePath);

        try {
            //파일에 문자열을 쓴다.
            //하지만 이미 파일이 존재하면 모든 내용을 삭제하고 그위에 덮어쓴다
            //파일이 손산될 우려가 있다.
            FileWriter fw = new FileWriter(file);
            for (Long token : list) {
                fw.write(token.toString() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static private void writeSet(final Set<Long> set, final String outputFilePath) {
        File file = new File(outputFilePath);

        try {
            //파일에 문자열을 쓴다.
            //하지만 이미 파일이 존재하면 모든 내용을 삭제하고 그위에 덮어쓴다
            //파일이 손산될 우려가 있다.
            FileWriter fw = new FileWriter(file);
            for (Long token : set) {
                fw.write(token.toString() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
