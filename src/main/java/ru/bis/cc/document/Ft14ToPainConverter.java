package ru.bis.cc.document;

import ru.bis.cc.FileHelper;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;

public class Ft14ToPainConverter {
    private static final String SOURCE_CODEPAGE = "Cp1251"; //Cp866 для DOS, Cp1251 для Windows-1251, KOI8_R для КОИ-8
    private static final String DEST_CODEPAGE = "Cp1251";

    public static void main(String[] args) {
        String sourcePath = FileHelper.chooseSourceFile("Выберите файл FT14");
        if (sourcePath != null) {
            Charset charsetSource = Charset.forName(SOURCE_CODEPAGE);
            Charset charsetDest = Charset.forName(DEST_CODEPAGE);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourcePath), charsetSource))) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    Document document = new Document();
                    document.buildDocument(line);
                    System.out.println(document);


/*
                    String destPath = getDestinationFile(sourcePath);
                    try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(destPath), charsetDest))) {
                        writer.println(line);
                    } catch (FileNotFoundException e) {
                        FileHelper.showMessage("Произошла ошибка !", "Ошибка", true);
                        e.printStackTrace();
                    }
*/
                }


                FileHelper.showMessage("Обработка завершена успешно !", "", false);
            } catch (IOException e) {
                FileHelper.showMessage("Произошла ошибка !", "Ошибка", true);
                e.printStackTrace();
            }
        }

    }

    private static String getDestinationFile(String sourceFile) {
        String sourceFileName = Path.of(sourceFile).getFileName().toString();
        int pointIndex = sourceFileName.indexOf(".");
        String destFileName = sourceFileName.substring(0, pointIndex) + "_copy." +
                sourceFileName.substring(pointIndex + 1);
        return Path.of(sourceFile).getParent().resolve(Path.of(destFileName)).toString();
    }
}
