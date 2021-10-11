package ood.lsp;

import org.quartz.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllQuality implements Job {

   private List<Storage> list;

    public ControllQuality(List<Storage> list) {
        this.list = list;
    }

    public void put(Products products) {
        for (Storage s : list) {
            s.add(products);
        }
    }

    public void inputStorage() {
        for (Storage s : list) {
                System.out.println(s);
        }
    }

    public void resort() {
        List<Products> listProducts = new ArrayList<>();
        for (Storage s : list) {
            listProducts.addAll(s.getList());
        }
        list = List.of(new Warehouse(), new Trash(), new Shop());
        for (Products p : listProducts) {
            put(p);
        }
    }

    public static void main(String[] args) throws SchedulerException {
        LocalDate localDate = LocalDate.of(2021, 10, 25);
        LocalDate localDate1 = LocalDate.of(2021, 9, 23);
        LocalDate localDate2 = LocalDate.of(2021, 10, 10);
        ControllQuality controllQuality = new ControllQuality(List.of(new Warehouse(), new Trash(), new Shop()));
        Products products1 = new Fish("Окунь", localDate, localDate1, 50, 0.3);
        controllQuality.put(products1);
        Products products2 = new Food("Беляш", localDate2, localDate1, 40, 0.75);
        controllQuality.put(products2);
        DynamicAllocation dynamicAllocation = new DynamicAllocation();
        Scheduler scheduler = dynamicAllocation.scheduler();
        dynamicAllocation.init(scheduler);
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Начало перераспределения продуктов...");
        resort();
        System.out.println("Перераспределение продуктов закончено!");
    }
}
