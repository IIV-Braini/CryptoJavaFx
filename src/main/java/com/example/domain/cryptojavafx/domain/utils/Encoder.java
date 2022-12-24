package com.example.domain.cryptojavafx.domain.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Encoder {


    /**
     * Основной метод, для кодировки файла с помощью ключа key.
     */
    public void encode(String fileIn, String fileOut, Integer key) {
        try (FileWriter writer = new FileWriter(fileOut)) {
            writer.write(encodeFileToString(fileIn, key));
        } catch (IOException e) {
            System.out.println("error file out name");
        }
    }

    /**
     *  Метод, для декодировки файла с помощью ключа key.
     */
    public void decode(String fileIn, String fileOut, Integer key) {
        encode(fileIn, fileOut, key * -1);
    }

    /**
     * Метод, для декодирования файла путем подбора ключа.
     */
    public void encodeWithAnalysis(String fileIn, String filePathForStaticAnalysis) {
        int key = StaticAnalyzer.selectionKey(fileIn, filePathForStaticAnalysis) % 26;
        String fileOut = fileIn.replace("encoded", "decoded k-" + key);
        try (FileWriter writer = new FileWriter(fileOut)) {
            writer.write(encodeFileToString(fileIn, key * -1));
        } catch (IOException e) {
            System.out.println("error file out name");
        }
    }

    /**
     * Метод возвращает файл в виде строки, закодированный ключем key.
     */
    private String encodeFileToString(String fileIn, Integer key) throws IOException {
        List<String> strings = Files.readAllLines(Path.of(fileIn));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(encodeString(s, key));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Метод возвращает закодированную строку ключем key
     */
    private String encodeString(String s, Integer key) {
        StringBuilder result = new StringBuilder();
        char[] characters = s.toCharArray();
        for (Character c : characters) {
            result.append(encodeCharacter(c, key));
        }
        return result.toString();
    }

    /**
     * Возвращает закодированный символ
     */
    private Character encodeCharacter(Character character, Integer key) {
        if (!Alphabet.isContain(character)) return character;
        else {
            key = key % 26;
            int index = Alphabet.getIndex(character) + key;
            if (Character.isUpperCase(character)) {
                if (index > 51) index -= 26;
                if (index < 26) index += 26;
            } else {
                if (index > 25) index -= 26;
                if (index < 0) index += 26;
            }
            return Alphabet.getChar(index);
        }
    }



}

