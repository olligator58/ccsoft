package ru.bis.cc.utils;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.File;

public class FileHelper {
    private static final String DEFAULT_DIRECTORY = "C:\\work\\РЦ\\files\\";

    public static String chooseSourceFile(String requestText) {
        String result = null;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println(requestText);
        showMessage(requestText, "Выберите файл", false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        JFileChooser fileChooser = new JFileChooser(DEFAULT_DIRECTORY);
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            result = fileChooser.getSelectedFile().toString();
        } else {
            System.out.println("Вы не выбрали требуемый файл. Попробуйте снова.");
            showMessage("Вы не выбрали требуемый файл. Попробуйте снова.", "Ошибка", true);
        }
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        return result;
    }

    public static String chooseSourceDirectory(String requestText) {
        String result = null;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        System.out.println(requestText);
        showMessage(requestText, "Выберите каталог", false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }
        JFileChooser fileChooser = new JFileChooser(DEFAULT_DIRECTORY);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            result = fileChooser.getSelectedFile().toString();
        } else {
            System.out.println("Вы не выбрали требуемый каталог. Попробуйте снова.");
            showMessage("Вы не выбрали требуемый каталог. Попробуйте снова.", "Ошибка", true);
        }
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        return result;
    }

    public static void showMessage(String message, String title, boolean isError) {
        int messageType = (!isError) ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }

    public static void deleteDirRecursively(File dir, boolean isSilentMode) {
        if (!dir.isDirectory()) {
            if (!isSilentMode) {
                System.out.println("Каталог " + dir.getPath() + " не существует !");
            }
            return;
        }

        File[] children = dir.listFiles();
        for (File child : children) {
            if (child.isDirectory()) {
                deleteDirRecursively(child, isSilentMode);
            } else {
                deleteAndReport(child, isSilentMode);
            }

        }

        deleteAndReport(dir, isSilentMode);
    }

    private static void deleteAndReport(File file, boolean isSilentMode) {
        String fileType = (file.isDirectory()) ? "Каталог " : "Файл ";
        boolean isSuccessDeleted = file.delete();
        if (isSilentMode) {
            return;
        }
        String result = (isSuccessDeleted) ? " удален успешно !" : " не был удален !";
        System.out.println(fileType + file.getPath() + result);
    }
}