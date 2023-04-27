package app;

import app.product.Product;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

public class Menu {
    private Product[] products;

    public Menu(Product[] products) {
        this.products = products;
    }

    public void printMenu() {
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(60));
        System.out.println("🍔 햄버거");
        printHamburgers(true);
        System.out.println("🍟 사이드");
        printSides(true);
        System.out.println("🥤 음료");
        printDrinks(true);

        System.out.println("");
        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(60));
        System.out.println("[📢] 메뉴를 선택해주세요. : ");

    }

    protected void printDrinks(boolean printPrice) {
        for (Product product : products) {
            if (product instanceof Drink) printEachMenu(product, printPrice);
        }
    }

    protected void printSides(boolean printPrice) {
        for (Product product : products) {
            if (product instanceof Side) printEachMenu(product, printPrice);
        }
    }

    private void printHamburgers(boolean printPrice) {
        for (Product product : products) {
            if (product instanceof Hamburger) {
                printEachMenu(product, printPrice);
            }
        }
    }

    private static void printEachMenu(Product product, boolean printPrice) {
        if (printPrice) System.out.printf("(%d) %s %5dkcal %5d원%n", product.getId(), product.getName(), product.getKcal(), product.getPrice());
        else System.out.printf("(%d) %s %5dKcal%n", product.getId(), product.getName(), product.getKcal());
    }
}
