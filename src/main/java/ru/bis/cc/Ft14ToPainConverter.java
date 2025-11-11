package ru.bis.cc;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import ru.bis.cc.document.Document;
import ru.bis.cc.document.DocumentToDtoConverter;
import ru.bis.cc.dto.DocumentDto;
import ru.bis.cc.utils.FileHelper;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ft14ToPainConverter {
    private static final String SOURCE_CODEPAGE = "ISO8859_5"; //Cp866 для DOS, Cp1251 для Windows-1251, KOI8_R для КОИ-8
    private static final String DEST_CODEPAGE = "UTF-8";
    private static final String DEST_DIR = "iso";

    public static void main(String[] args) {
        String sourceFile = FileHelper.chooseSourceFile("Выберите файл FT14");
        if (sourceFile != null) {
            Charset charsetSource = Charset.forName(SOURCE_CODEPAGE);
            Charset charsetDest = Charset.forName(DEST_CODEPAGE);

            if (!prepareOutDir(sourceFile)) {
                FileHelper.showMessage("Не удалось создать каталог " + DEST_DIR, "Ошибка", true);
                return;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), charsetSource))) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    Document document = new Document();
                    document.buildDocument(line);
//                    System.out.println(document);

                    String destFileName = resolveDestFileName(sourceFile, document.getPayerInn(), document.getNumber(), document.getDate());
                    try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(destFileName), charsetDest))) {
                        writer.println(documentToXml(document));
                    } catch (FileNotFoundException e) {
                        FileHelper.showMessage("Произошла ошибка !", "Ошибка", true);
                        e.printStackTrace();
                    }
                }


                FileHelper.showMessage("Обработка завершена успешно !", "", false);
            } catch (IOException e) {
                FileHelper.showMessage("Произошла ошибка !", "Ошибка", true);
                e.printStackTrace();
            }
        }

    }

    private static boolean prepareOutDir(String sourceFileName) {
        File outDir = new File(Path.of(sourceFileName).getParent().resolve(DEST_DIR).toString());
        FileHelper.deleteDirRecursively(outDir, false);
        return outDir.mkdir();
    }

    private static String resolveDestFileName(String sourceFile, String inn, String number, LocalDate date) {
        LocalDateTime dateTime = LocalDateTime.of(date, LocalDateTime.now().toLocalTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSSSS");
        String timestamp = dateTime.format(formatter);

        Path dir = Path.of(sourceFile).getParent().resolve(DEST_DIR);
        String fileName = "PAIN001UTF8_" + number + "_" + inn + "_" + timestamp;
        return dir.resolve(fileName).toString();
    }

    private static String documentToXml(Document document) {
        DocumentToDtoConverter converter = new DocumentToDtoConverter();
        DocumentDto dto = converter.convert(document);
        StringWriter writer = new StringWriter();
        writer.append("<?xml version=\"1.1\" encoding=\"UTF-8\"?>\n");
        try {
            JAXBContext context = JAXBContext.newInstance(DocumentDto.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.marshal(dto, writer);
            return writer.toString();
        } catch (JAXBException e) {
            FileHelper.showMessage("Ошибка при записи документа в файл !", "Ошибка", true);
            e.printStackTrace();
        }
        return null;
    }
}
