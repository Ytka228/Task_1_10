
package com.mycompany.kovtask_1_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class KovTask_1_10 {
    public static void main(String[] args) {
        System.out.println("Вариант 2. Ковальчук Артём Викторович.");
        try {
            // Пользователь вводит путь до файла
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите путь до файла: ");
            String filePath = reader.readLine();
            
            // Чтение строк из файла
            BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
            String line;
            StringBuilder reversedLines = new StringBuilder();
            while ((line = fileReader.readLine()) != null) {
                // Преобразование строки в обратном порядке
                String reversedLine = reverseString(line);
                reversedLines.append(reversedLine).append("\n");
            }
            fileReader.close();
            
            // Запись получившихся строк в новый файл
            String newFilePath = getNewFilePath(filePath);
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(newFilePath));
            fileWriter.write(reversedLines.toString());
            fileWriter.close();
            
            System.out.println("Преобразование успешно выполнено. Новый файл создан: " + newFilePath);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
    
    private static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }
    
    private static String getNewFilePath(String filePath) {
        int dotIndex = filePath.lastIndexOf('.');
        String extension = "";
        if (dotIndex != -1) {
            extension = filePath.substring(dotIndex);
        }
        return filePath.replace(extension, "_reversed" + extension);
    }
}

