package ood.srp;

import java.util.function.Predicate;

public class ReportBookkeeping implements Report {

    private int rubleRate;
    private Store store;

    public ReportBookkeeping(Store store, int rubleRate) {
        this.store = store;
        this.rubleRate = rubleRate;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; SalaryRub;");
        text.append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * rubleRate).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
