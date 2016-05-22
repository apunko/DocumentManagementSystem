package DocumentsUtils;

import Models.Contract;
import Services.ContractService;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class XlsUtils {

    public static ByteArrayOutputStream generateContractsXls() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Contracts");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("№"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Client"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Template type"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Pay Form"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Pay Sum"));
        cell = row.createCell(5);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Pay Date"));
        cell = row.createCell(6);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Start Date"));
        cell = row.createCell(7);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("End Date"));
        ContractService service = new ContractService();
        List<Contract> contracts = service.getAll();
        for (int i = 0; i < contracts.size(); i++) {
            row = sheet.createRow(i + 1);

            Contract contract = contracts.get(i);
            cell = row.createCell(0);
            cell.setCellValue(contract.getId());
            cell = row.createCell(1);
            cell.setCellValue(contract.getClient().getFullName());
            cell = row.createCell(2);
            cell.setCellValue(contract.getTemplate().getTitle());
            cell = row.createCell(3);
            cell.setCellValue(contract.getPayForm().getType());
            cell = row.createCell(4);
            cell.setCellValue(contract.getPaySum());
            cell = row.createCell(5);
            cell.setCellValue(contract.getStringPayDate());
            cell = row.createCell(6);
            cell.setCellValue(contract.getStringStartDate());
            cell = row.createCell(7);
            cell.setCellValue(contract.getStringEndDate());
        }
        HSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        for (int j = 0; j <= contracts.size(); j++) {
            row = sheet.getRow(j);
            row.setRowStyle(style);
            for (int i = 0; i < 8; i++) {
                row.getCell(i).setCellStyle(style);
                sheet.autoSizeColumn(i);
            }
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }

    public static ByteArrayOutputStream generateDepartmentsXls() throws IOException {
        return null;
    }

    public static ByteArrayOutputStream generateProjectsXls() throws IOException {
        return null;
    }

    public static ByteArrayOutputStream generateUsersXls() throws IOException {
        return null;
    }

    public static ByteArrayOutputStream generateWorksXls() throws IOException {
        return null;
    }
}
