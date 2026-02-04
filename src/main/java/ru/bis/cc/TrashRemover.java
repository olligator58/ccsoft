package ru.bis.cc;

import ru.bis.cc.utils.FileHelper;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Set;

public class TrashRemover {
    private static final String SOURCE_CODEPAGE = "UTF-8";
    private static final String DEST_CODEPAGE = "UTF-8";
    private static final Set<String> STARTS = Set.of("<messageLinks>", "<processInstanceErrors>", "<systemObjectSigns>");
    private static final Set<String> ENDS = Set.of("</messageLinks>", "</processInstanceErrors>", "</systemObjectSigns>");

    public static void main(String[] args) {
        String sourcePath = FileHelper.chooseSourceFile("Выберите файл с документами");
        if (sourcePath != null) {
            String destPath = getDestinationFile(sourcePath);
            Charset charsetSource = Charset.forName(SOURCE_CODEPAGE);
            Charset charsetDest = Charset.forName(DEST_CODEPAGE);
            boolean skip = false;

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourcePath), charsetSource));
                 PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(destPath), charsetDest))) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    for (String start : STARTS) {
                        if (line.contains(start)) {
                            skip = true;
                            break;
                        }
                    }
                    if (!skip) {
                        writer.println(line);
                    }
                    for (String end : ENDS) {
                        if (line.contains(end)) {
                            skip = false;
                            break;
                        }
                    }
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
