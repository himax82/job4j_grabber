package ood.srp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Predicate;

public class ReportProgrammer implements Report {

    private Store store;

    public ReportProgrammer(Store store) {
        this.store = store;
    }

    public File html(String text) throws IOException {
        File f = new File("report.htm");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(text);
        bw.close();
        return f;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html><body><h1>Report Employee!</h1>");
        text.append("<textarea cols=75 rows=10>");
        text.append("Name; Hired; Fired; Salary");
        text.append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</textarea>");
        text.append("</body></html>");
        return text.toString();
    }
}
