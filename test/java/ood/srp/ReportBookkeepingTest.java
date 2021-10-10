package ood.srp;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportBookkeepingTest {

    @Test
    public void whenGeneratedReport() throws JAXBException {
        int rubleRate = 73;
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Max", now, now, 100);
        store.add(worker);
        Report bookkeeping = new ReportBookkeeping(store, rubleRate);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; SalaryRub;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * rubleRate).append(";")
                .append(System.lineSeparator());
        assertThat(bookkeeping.generate(em -> true), is(expect.toString()));
    }

}