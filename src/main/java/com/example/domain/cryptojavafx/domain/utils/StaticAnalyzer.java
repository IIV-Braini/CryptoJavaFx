package com.example.domain.cryptojavafx.domain.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StaticAnalyzer {

    /**
     * Метод возвращает ключ, позволяющий расшифромать первый файл, полученный сравнением частоты встречаемости букв в 2х файлах.
     */
    public static Integer selectionKey(String fileIn, String filePathForStaticAnalysis) {
        int key = 0;
        List<Double> percentageSymbolsInFileIn = countCharacterFrequencyInPercent(fileIn);
        List<Double> percentageSymbolsInFileForAnalysis = countCharacterFrequencyInPercent(filePathForStaticAnalysis);
        Double sum = Double.MAX_VALUE;
        for (int i = 0; i < 52; i++) {
            Double count = countModuloDifference(percentageSymbolsInFileIn, percentageSymbolsInFileForAnalysis);
            if (count < sum) {
                sum = count;
                key = i;
            }
            Collections.rotate(percentageSymbolsInFileIn, -1);
        }
        return key;
    }

    /**
     * Метод возвращает значения в процентах, встречаемости букв из нашего алфавита.
     */
    private static List<Double> countCharacterFrequencyInPercent(String filePath) {
        double countAllSymbolsInFile = 0;
        double[] countSymbolsArray = new double[52];
        List<Double> countSymbolsInPercent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) {
                char symbol = (char) reader.read();
                if (Alphabet.isContain(symbol)) {
                    int index = Alphabet.getIndex(symbol);
                    countSymbolsArray[index]++;
                    countAllSymbolsInFile++;
                }
            }
            for (int i = 0; i < 52; i++) {
                countSymbolsInPercent.add(countSymbolsArray[i] / countAllSymbolsInFile * 100);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countSymbolsInPercent;
    }

    /**
     * Метод возвращает сумму разниц по модулю, между двумя списками
     */
    private static Double countModuloDifference(List<Double> list, List<Double> listForAnalysis) {
        double sum = 0.0;
        for (int i = 0; i < list.size(); i++) {
            sum += Math.abs (list.get(i) - listForAnalysis.get(i));
        }
        return sum;
    }



}
