package DocumentsUtils;

import Models.*;
import Services.*;
import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CsvUtils {

    public static ByteArrayOutputStream generateContractsInCSV() throws IOException {
        String[] fileHeader = {"№", "Client", "Template", "Pay Form", "Pay Sum", "Pay Date", "Start Date", "End Date"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        OutputStreamWriter os = new OutputStreamWriter(stream);
        CSVWriter writer = new CSVWriter(os, ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new ArrayList<String[]>();
        ContractService service = new ContractService();
        List<Contract> contracts = service.getAll();
        for (int i = 0; i < contracts.size(); i++) {
            Contract contract = contracts.get(i);
            vacanciesInString.add(new String[]{
                    Integer.toString(contract.getId()),
                    contract.getClient().getFullName(),
                    contract.getTemplate().getTitle(),
                    contract.getPayForm().getType(),
                    Integer.toString(contract.getPaySum()),
                    contract.getStringPayDate(),
                    contract.getStringStartDate(),
                    contract.getStringEndDate()
                    });
        }

        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateDepartmentsInCSV() throws IOException {
        String[] fileHeader = {"Name", "Description", "Users Amount"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        OutputStreamWriter os = new OutputStreamWriter(stream);
        CSVWriter writer = new CSVWriter(os, ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new ArrayList<String[]>();
        DepartmentService service = new DepartmentService();
        List<Department> departments = service.getAll();
        for (int i = 0; i < departments.size(); i++) {
            Department department = departments.get(i);
            vacanciesInString.add(new String[]{
                    department.getName(),
                    department.getDescription(),
                    Integer.toString(department.getEmployees().size())
            });
        }

        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateProjectsInCSV() throws IOException {
        String[] fileHeader = {"Title", "Description", "Plan End Date", "Belongs to Contract", "Works Amount", "Employees on Project"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        OutputStreamWriter os = new OutputStreamWriter(stream);
        CSVWriter writer = new CSVWriter(os, ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new ArrayList<String[]>();
        ProjectService service = new ProjectService();
        List<Project> projects = service.getAll();
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            vacanciesInString.add(new String[]{
                    project.getTitle(),
                    project.getDescription(),
                    project.getStringPlanEndDate(),
                    "№" + project.getContract().getId(),
                    Integer.toString(project.getWorks().size()),
                    Integer.toString(project.getEmployees().size())
            });
        }

        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateWorksInCSV() throws IOException {
        String[] fileHeader = {"Title", "Description", "Start Date", "End Date", "Belongs to Project", "Employees on Work"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        OutputStreamWriter os = new OutputStreamWriter(stream);
        CSVWriter writer = new CSVWriter(os, ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new ArrayList<String[]>();
        WorkService service = new WorkService();
        List<Work> works = service.getAll();
        for (int i = 0; i < works.size(); i++) {
            Work work = works.get(i);
            vacanciesInString.add(new String[]{
                    work.getTitle(),
                    work.getDescription(),
                    work.getStringStartDate(),
                    work.getStringEndDate(),
                    work.getProject().getTitle(),
                    Integer.toString(work.getEmployees().size())
            });
        }

        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }

    public static ByteArrayOutputStream generateUsersInCSV() throws IOException {
        String[] fileHeader = {"Full Name", "Email", "Role", "Position", "Has contracts", "Belongs to Projects", "Belongs to Works"};
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        OutputStreamWriter os = new OutputStreamWriter(stream);
        CSVWriter writer = new CSVWriter(os, ',');
        writer.writeNext(fileHeader);
        List<String[]> vacanciesInString = new ArrayList<String[]>();
        UserService service = new UserService();
        List<User> users = service.getAll();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            vacanciesInString.add(new String[]{
                    user.getFullName(),
                    user.getEmail(),
                    user.getRole(),
                    user.getPosition(),
                    Integer.toString(user.getContracts().size()),
                    Integer.toString(user.getProjects().size()),
                    Integer.toString(user.getWorks().size()),
            });
        }

        writer.writeAll(vacanciesInString);
        writer.close();
        return stream;
    }
}
