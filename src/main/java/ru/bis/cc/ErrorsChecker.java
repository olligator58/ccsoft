package ru.bis.cc;

import ru.bis.cc.utils.FileHelper;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorsChecker {
    private static final String SOURCE_CODEPAGE = "UTF-8";
    private static final String DEST_CODEPAGE = "UTF-8";
    private static final Pattern ERROR = Pattern.compile("Ошибка (\\w+)");
    private static final Pattern NOT_ERROR = Pattern.compile("!(\\w+)");

    public static void main(String[] args) {
        String sourcePath = FileHelper.chooseSourceFile("Выберите файл с документами");
        if (sourcePath != null) {
            String destPath = getDestinationFile(sourcePath);
            Charset charsetSource = Charset.forName(SOURCE_CODEPAGE);
            Charset charsetDest = Charset.forName(DEST_CODEPAGE);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourcePath), charsetSource));
                 PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(destPath), charsetDest))) {
                Document document = null;
                List<Document> documents = new ArrayList<>();
                while (reader.ready()) {
                    String line = reader.readLine().trim();
                    if (line.contains("<fullNumber>")) {
                        document = new Document();
                        document.setNumber(line.replaceAll("</?\\w+>", ""));
                    }
                    if (line.contains("<purpose>")) {
                        Matcher matcher = ERROR.matcher(line);
                        while (matcher.find()) {
                            document.getSupposedErrors().add(matcher.group(1));
                        }
                        matcher = NOT_ERROR.matcher(line);
                        while (matcher.find()) {
                            document.getSupposedNotErrors().add(matcher.group(1));
                        }
                    }
                    if (line.contains("<bisError")) {
                        document.getRealErrors().add(line.replaceAll("<bisError sysName=\"", "")
                                .replaceAll("\"/>", ""));
                    }
                    if (line.contains("</PaymentDocument>")) {
                        documents.add(document);
                    }
                }
                documents.sort(Comparator.comparing(Document::getNumber));
                for (Document doc : documents) {
                    processDocument(doc, writer);
                }
                FileHelper.showMessage("Обработка завершена успешно !", "", false);
            } catch (IOException e) {
                FileHelper.showMessage("Произошла ошибка !", "Ошибка", true);
                e.printStackTrace();
            }
        }
    }

    private static String getDestinationFile(String sourceFile) {
        return Path.of(sourceFile).getParent().resolve(Path.of("check_results.txt")).toString();
    }

    private static void processDocument(Document document, PrintWriter writer) {
        boolean isGood = true;
        for (String error : document.getSupposedErrors()) {
            if (!document.getRealErrors().contains(error)) {
                isGood = false;
                writer.println(String.format("*%s: отсутствует ошибка %s", document.getNumber(), error));
            }
        }
        for (String error : document.getSupposedNotErrors()) {
            if (document.getRealErrors().contains(error)) {
                isGood = false;
                writer.println(String.format("*%s: лишняя ошибка %s", document.getNumber(), error));
            }
        }
        if (isGood) {
            writer.println(String.format("%s: OK", document.getNumber()));
        }
    }

    private static class Document {
        private String number;
        private final Set<String> supposedErrors = new HashSet<>();
        private final Set<String> supposedNotErrors = new HashSet<>();
        private final Set<String> realErrors = new HashSet<>();

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public Set<String> getSupposedErrors() {
            return supposedErrors;
        }

        public Set<String> getSupposedNotErrors() {
            return supposedNotErrors;
        }

        public Set<String> getRealErrors() {
            return realErrors;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "number='" + number + '\'' +
                    ", supposedErrors=" + supposedErrors +
                    ", supposedNotErrors=" + supposedNotErrors +
                    ", realErrors=" + realErrors +
                    '}';
        }
    }
}
