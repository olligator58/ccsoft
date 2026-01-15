package ru.bis.cc;

import java.util.Arrays;
import java.util.Scanner;

public class UinChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите УИН:");
        String initialUin = scanner.nextLine();
        if (initialUin.length() != 20 && initialUin.length() != 25) {
            System.out.println("Длина УИН должна быть 20 или 25 символов !!!");
            return;
        }
        int[] uin = Arrays.stream(initialUin.substring(0, initialUin.length() - 1).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] weights = new int[uin.length];
        for (int i = 0; i < weights.length; i++) {
            int weight = (i + 1) % 10;
            if (weight == 0) {
                weight = 10;
            }
            weights[i] = weight;
        }
        int key;
        while (true) {
            int production = 0;
            for (int i = 0; i < uin.length; i++) {
                production += uin[i] * weights[i];
            }
            key = production % 11;
            if (production != 10) {
                break;
            }
            shiftWeights(weights, 2);
        }
        String answer = (key != Integer.parseInt(initialUin.substring(initialUin.length() - 1))) ?
                "Ваш УИН неверен !!! Корректный УИН:" : "Ваш УИН корректен:";
        String rightUin = initialUin.substring(0, initialUin.length() - 1) + key;
        System.out.println(answer);
        System.out.println(rightUin);
        scanner.close();
    }

    private static void shiftWeights(int[] weights, int offset) {
        for (int i = 0; i < weights.length; i++) {
            int number = weights[i] + offset;
            if (number > 10) {
                number -= 10;
            }
            weights[i] = number;
        }

    }
}