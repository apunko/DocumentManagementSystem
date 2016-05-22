package DocumentsUtils;

import Models.*;
import Services.*;
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
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Departments");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Name"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Description"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Users Amount"));

        DepartmentService service = new DepartmentService();
        List<Department> departments = service.getAll();
        for (int i = 0; i < departments.size(); i++) {
            row = sheet.createRow(i + 1);

            Department department = departments.get(i);
            cell = row.createCell(0);
            cell.setCellValue(department.getName());
            cell = row.createCell(1);
            cell.setCellValue(department.getDescription());
            cell = row.createCell(2);
            cell.setCellValue(department.getEmployees().size());
        }
        HSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        for (int j = 0; j <= departments.size(); j++) {
            row = sheet.getRow(j);
            row.setRowStyle(style);
            for (int i = 0; i < 3; i++) {
                row.getCell(i).setCellStyle(style);
                sheet.autoSizeColumn(i);
            }
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }

    public static ByteArrayOutputStream generateProjectsXls() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Projects");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Title"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Description"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Plan End Date"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Belongs to Contract"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Works Amount"));
        cell = row.createCell(5);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Employees on Project"));

        ProjectService service = new ProjectService();
        List<Project> projects = service.getAll();
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            row = sheet.createRow(i + 1);

            cell = row.createCell(0);
            cell.setCellValue(project.getTitle());
            cell = row.createCell(1);
            cell.setCellValue(project.getDescription());
            cell = row.createCell(2);
            cell.setCellValue(project.getStringPlanEndDate());
            cell = row.createCell(3);
            cell.setCellValue("№" + project.getContract().getId());
            cell = row.createCell(4);
            cell.setCellValue(project.getWorks().size());
            cell = row.createCell(5);
            cell.setCellValue(project.getEmployees().size());
        }
        HSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        for (int j = 0; j <= projects.size(); j++) {
            row = sheet.getRow(j);
            row.setRowStyle(style);
            for (int i = 0; i < 6; i++) {
                row.getCell(i).setCellStyle(style);
                sheet.autoSizeColumn(i);
            }
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }

    public static ByteArrayOutputStream generateUsersXls() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Users");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Full Name"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Email"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Role"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Position"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Has contracts"));
        cell = row.createCell(5);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Belongs to Projects"));
        cell = row.createCell(6);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Belongs to Works"));

        UserService service = new UserService();
        List<User> users = service.getAll();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            row = sheet.createRow(i + 1);

            cell = row.createCell(0);
            cell.setCellValue(user.getFullName());
            cell = row.createCell(1);
            cell.setCellValue(user.getEmail());
            cell = row.createCell(2);
            cell.setCellValue( user.getRole());
            cell = row.createCell(3);
            cell.setCellValue(user.getPosition());
            cell = row.createCell(4);
            cell.setCellValue(user.getContracts().size());
            cell = row.createCell(5);
            cell.setCellValue(user.getProjects().size());
            cell = row.createCell(6);
            cell.setCellValue(user.getWorks().size());
        }
        HSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        for (int j = 0; j <= users.size(); j++) {
            row = sheet.getRow(j);
            row.setRowStyle(style);
            for (int i = 0; i < 7; i++) {
                row.getCell(i).setCellStyle(style);
                sheet.autoSizeColumn(i);
            }
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }

    public static ByteArrayOutputStream generateWorksXls() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Works");
        HSSFCellStyle headerCellStyle = workbook.createCellStyle();
        HSSFFont boldFont = workbook.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Title"));
        cell = row.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Description"));
        cell = row.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Start Date"));
        cell = row.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("End Date"));
        cell = row.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Belongs to Project"));
        cell = row.createCell(5);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Employees on Work"));

        WorkService service = new WorkService();
        List<Work> works = service.getAll();
        for (int i = 0; i < works.size(); i++) {
            Work work = works.get(i);
            row = sheet.createRow(i + 1);

            cell = row.createCell(0);
            cell.setCellValue(work.getTitle());
            cell = row.createCell(1);
            cell.setCellValue(work.getDescription());
            cell = row.createCell(2);
            cell.setCellValue( work.getStringStartDate());
            cell = row.createCell(3);
            cell.setCellValue(work.getStringEndDate());
            cell = row.createCell(4);
            cell.setCellValue(work.getProject().getTitle());
            cell = row.createCell(5);
            cell.setCellValue(work.getEmployees().size());
        }
        HSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        for (int j = 0; j <= works.size(); j++) {
            row = sheet.getRow(j);
            row.setRowStyle(style);
            for (int i = 0; i < 6; i++) {
                row.getCell(i).setCellStyle(style);
                sheet.autoSizeColumn(i);
            }
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);
        return stream;
    }
}
