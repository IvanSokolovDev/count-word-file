package com.javarush.task.task19.task1907;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = "";

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String findWord = "world";
        StringBuilder text = new StringBuilder();
        int countFindWord = 0;

        try (FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.ready()) {
                text.append((char) fileReader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String textFile = text.toString().replaceAll("\\p{P}", " ").replaceAll("\\s", " ");
        StringTokenizer stringTokenizer = new StringTokenizer(textFile);

        while (stringTokenizer.hasMoreTokens()) {
            if (stringTokenizer.nextToken().equals(findWord)) {
                countFindWord++;
            }
        }
        System.out.println(countFindWord);
    }
}
