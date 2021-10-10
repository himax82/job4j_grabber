package ood.lsp;

import org.quartz.simpl.LoadingLoaderClassLoadHelper;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ControllQuality {

   private Warehouse warehouse;
   private Shop shop;
   private Trash trash;

    public ControllQuality(Warehouse warehouse, Shop shop, Trash trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Shop getShop() {
        return shop;
    }

    public Trash getTrash() {
        return trash;
    }

    public void put(Products products) {
        LocalDate now = LocalDate.now();
        double dayExpiry = (double) ChronoUnit.DAYS.between(now, products.getExpiryDate());
        double dayCreate = (double) ChronoUnit.DAYS.between(products.getCreateDate(), now);
        double dayStorage = (double) ChronoUnit.DAYS.between(products.getCreateDate(), products.getExpiryDate());
        if (dayCreate / dayStorage < 0.25) {
            warehouse.add(products);
        } else if (dayCreate / dayStorage >= 0.25 && dayCreate / dayStorage < 0.75) {
            shop.add(products);
        } else if (dayCreate / dayStorage >= 0.75 && dayCreate / dayStorage < 1) {
            products.setPrice(products.getPrice() * products.getDiscount());
            shop.add(products);
        } else if (dayExpiry <= 0) {
            trash.add(products);
        }
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2021, 10, 25);
        LocalDate localDate1 = LocalDate.of(2021, 9, 23);
        LocalDate localDate2 = LocalDate.of(2021, 10, 10);
        Products products1 = new Fish("Окунь", localDate, localDate1, 50, 0.3);
        ControllQuality controllQuality = new ControllQuality(new Warehouse(), new Shop(), new Trash());
        controllQuality.put(products1);
        Products products2 = new Food("Беляш", localDate2, localDate1, 40, 0.75);
        controllQuality.put(products2);
        System.out.println(controllQuality.shop.getList().size());
        System.out.println(controllQuality.trash.getList().size());
        System.out.println(controllQuality.warehouse.getList().size());
    }
}
