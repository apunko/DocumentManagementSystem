package DocumentsUtils;

import Models.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class PdfUtils {

    private static int FONT_SIZE_SMALL = 10;
    private static int FONT_SIZE_NORMAL = 14;
    private static int FONT_SIZE_BIG = 20;
    private static int VERTICAL_SPACE_TINY = 5;
    private static int VERTICAL_SPACE_SMALL = 20;
    private static int VERTICAL_SPACE_MEDIUM = 50;
    private static int VERTICAL_SPACE_BIG = 80;
    private static int HEIGHT_SMALL_LINE = FONT_SIZE_SMALL + 1;
    private static int HEIGHT_NORMAL_LINE = FONT_SIZE_NORMAL + VERTICAL_SPACE_TINY + 2;
    private static int HEIGHT_BIG_LINE = FONT_SIZE_NORMAL + VERTICAL_SPACE_TINY;

    private static final String TEMPLATE = "./res/t.jpg";
    private static final String FONT = "/fonts/times.ttf";

    private final static Font SMALL_FONT = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_SMALL);
    private final static Font NORMAL_FONT = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_NORMAL);
    private final static Font NORMAL_BOLD_FONT = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_NORMAL, Font.BOLD);
    private final static Font BIG_FONT = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_BIG, Font.BOLD);
    private final static Font BIG_BOLD_FONT = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, FONT_SIZE_BIG + 2, Font.BOLD);

    synchronized static public ByteArrayOutputStream getDocument(Contract contract) throws DocumentException, IOException {

        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream stream;

        stream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, stream);
        writer.setEncryption(null, null, PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
        writer.createXmpMetadata();
        document.open();

        PdfContentByte canvas = writer.getDirectContentUnder();
        URL a = ByteArrayOutputStream.class.getResource(TEMPLATE);
        Image image = Image.getInstance("templates/template.jpg");
        image.scaleAbsolute(PageSize.A4);
        image.setAbsolutePosition(0, 0);
        canvas.addImage(image);

        Paragraph paragraph = new Paragraph();
        paragraph.setFont(FontFactory.getFont(FontFactory.TIMES_BOLD, FONT_SIZE_BIG + 4));
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Contract №" + contract.getId()));
        document.add(paragraph);
        document.add(new LineSeparator());

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk(contract.getTemplate().getContent()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.add(new Chunk("Client " + contract.getClient().getFullName() + " will pay to \"Anton Punko Team Company\" " +
                contract.getPaySum() + "$ before end of payment day " +
                contract.getStringPayDate()+"."));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.add(new Chunk("The contract begins since " + contract.getStringStartDate() + " and ends " + contract.getStringEndDate() + "."));
        document.add(paragraph);

        document.close();
        return stream;
    }

    synchronized static public ByteArrayOutputStream getUserPdf(User user) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream stream;

        stream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, stream);
        writer.setEncryption(null, null, PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
        writer.createXmpMetadata();
        document.open();

        PdfContentByte canvas = writer.getDirectContentUnder();
        URL a = ByteArrayOutputStream.class.getResource(TEMPLATE);
        Image image = Image.getInstance("templates/template.jpg");
        image.scaleAbsolute(PageSize.A4);
        image.setAbsolutePosition(0, 0);
        canvas.addImage(image);

        Paragraph paragraph = new Paragraph();
        paragraph.setFont(FontFactory.getFont(FontFactory.TIMES_BOLD, FONT_SIZE_BIG + 4));
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk(user.getFullName()));
        document.add(paragraph);
        document.add(new LineSeparator());

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("First name: " + user.getFirstName()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Last name: " + user.getLastName()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Email: " + user.getEmail()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Role: " + user.getRole()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Position: " + user.getPosition()));
        document.add(paragraph);

        document.close();
        return stream;
    }

    synchronized static public ByteArrayOutputStream getDepartmentPdf(Department department) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream stream;

        stream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, stream);
        writer.setEncryption(null, null, PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
        writer.createXmpMetadata();
        document.open();

        PdfContentByte canvas = writer.getDirectContentUnder();
        URL a = ByteArrayOutputStream.class.getResource(TEMPLATE);
        Image image = Image.getInstance("templates/template.jpg");
        image.scaleAbsolute(PageSize.A4);
        image.setAbsolutePosition(0, 0);
        canvas.addImage(image);

        Paragraph paragraph = new Paragraph();
        paragraph.setFont(FontFactory.getFont(FontFactory.TIMES_BOLD, FONT_SIZE_BIG + 4));
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk(department.getName()));
        document.add(paragraph);
        document.add(new LineSeparator());

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Department name: " + department.getName()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Department description: " + department.getDescription()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Users amount in department: " + department.getEmployees().size()));
        document.add(paragraph);

        document.close();
        return stream;
    }

    synchronized static public ByteArrayOutputStream getProjectPdf(Project project) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream stream;

        stream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, stream);
        writer.setEncryption(null, null, PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
        writer.createXmpMetadata();
        document.open();

        PdfContentByte canvas = writer.getDirectContentUnder();
        URL a = ByteArrayOutputStream.class.getResource(TEMPLATE);
        Image image = Image.getInstance("templates/template.jpg");
        image.scaleAbsolute(PageSize.A4);
        image.setAbsolutePosition(0, 0);
        canvas.addImage(image);

        Paragraph paragraph = new Paragraph();
        paragraph.setFont(FontFactory.getFont(FontFactory.TIMES_BOLD, FONT_SIZE_BIG + 4));
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk(project.getTitle()));
        document.add(paragraph);
        document.add(new LineSeparator());

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Project title: " + project.getTitle()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Project description: " + project.getDescription()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Belongs to contract: №" + project.getContract().getId()));
        document.add(paragraph);

        document.close();
        return stream;
    }

    synchronized static public ByteArrayOutputStream getWorkPdf(Work work) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream stream;

        stream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, stream);
        writer.setEncryption(null, null, PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
        writer.createXmpMetadata();
        document.open();

        PdfContentByte canvas = writer.getDirectContentUnder();
        URL a = ByteArrayOutputStream.class.getResource(TEMPLATE);
        Image image = Image.getInstance("templates/template.jpg");
        image.scaleAbsolute(PageSize.A4);
        image.setAbsolutePosition(0, 0);
        canvas.addImage(image);

        Paragraph paragraph = new Paragraph();
        paragraph.setFont(FontFactory.getFont(FontFactory.TIMES_BOLD, FONT_SIZE_BIG + 4));
        paragraph.setSpacingAfter(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk(work.getTitle()));
        document.add(paragraph);
        document.add(new LineSeparator());

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Work title: " + work.getTitle()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Work description: " + work.getDescription()));
        document.add(paragraph);

        paragraph = new Paragraph();
        paragraph.setFont(NORMAL_FONT);
        paragraph.setSpacingBefore(VERTICAL_SPACE_TINY);
        paragraph.add(new Chunk("Belongs to project: " + work.getProject().getTitle()));
        document.add(paragraph);

        document.close();
        return stream;
    }
}
