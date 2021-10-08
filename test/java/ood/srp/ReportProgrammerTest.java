package ood.srp;

import com.mchange.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportProgrammerTest {

    @Test
    public void whenOGeneratedReportHtml() throws IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Max", now, now, 100);
        store.add(worker);
        ReportProgrammer reportProgrammer = new ReportProgrammer(store);
        File f = new File("report.htm");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("<html><body><h1>Report Employee!</h1>");
        bw.write("<textarea cols=75 rows=10>");
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        bw.write(expect.toString());
        bw.write("</textarea>");
        bw.write("</body></html>");
        bw.close();
        assertEquals(f, reportProgrammer.html(reportProgrammer.generate(em -> true)));
    }

}