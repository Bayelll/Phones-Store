import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (!askToVisitStore()) {
            System.out.println("До свидания! Хорошего дня!");
            return;
        }

        Klient klient = new Klient();
        Banker banker = new Banker();
        Store store = new Store();
        Cashier cashier = new Cashier();
        Consultant consultant = new Consultant();

        while (true) {
            displayStoreInfo(klient, store);
            handleShopping(klient, store, cashier, banker, consultant);
        }
    }

    private static boolean askToVisitStore() {
        System.out.println("Желаете посетить наш магазин? (Y/N)");
        return getYesOrNo();
    }

    private static void displayStoreInfo(Klient klient, Store store) {
        store.printPhones();
        System.out.println("\nВаш баланс: " + klient.getBalance() + " $");
        System.out.println("Ваш долг: " + klient.getDuty() + " $");
        System.out.println("\nДобрый день! Я ваш консультант. Я помогу выбрать товар или направлю вас к банкиру, если средств недостаточно.");
    }

    private static void handleShopping(Klient klient, Store store, Cashier cashier, Banker banker, Consultant consultant) {
        System.out.println("\nТовары в корзине:");
        klient.getBasket().printBasket();
        System.out.println("\nНажмите 1, чтобы добавить товар в корзину, или 2 для выхода.");

        if (!getUserChoice("1", "2").equals("1")) {
            System.out.println("Доброго дня!");
            System.exit(0);
        }

        addItemsToBasket(klient, store, consultant);
        if (klient.getBasket().isEmpty()) {
            System.out.println("Ваша корзина пуста!");
            return;
        }

        System.out.println("\nВы готовы к оплате? (Y/N)");
        if (!getYesOrNo()) {
            System.out.println("Покупка отменена.");
            klient.getBasket().clearBasket();
            return;
        }

        processPayment(klient, cashier, banker);
    }

    private static void addItemsToBasket(Klient klient, Store store, Consultant consultant) {
        while (true) {
            System.out.println("Введите ID товара (8 цифр) или 0 для завершения покупок:");
            String strId = new Scanner(System.in).nextLine();

            if (strId.equals("0")) break;
            if (strId.length() != 8 || !strId.matches("\\d+")) {
                System.out.println("Некорректный ID. Попробуйте снова.");
                continue;
            }

            int id = Integer.parseInt(strId);
            if (consultant.search(id, store, klient)) {
                System.out.println("Товар добавлен в корзину.");
                klient.getBasket().printBasket();
            } else {
                System.out.println("Товар с таким ID не найден.");
            }
        }
    }

    private static void processPayment(Klient klient, Cashier cashier, Banker banker) {
        if (cashier.checkBalance(klient.getBalance(), klient)) {
            System.out.println("Поздравляем с покупкой!");
            cashier.minusPrice(klient);
            klient.getBasket().clearBasket();
            System.out.println("Ваш текущий баланс: " + klient.getBalance() + " $");
        } else {
            System.out.println("Недостаточно средств на счете.");
            handleBanking(klient, banker);
        }
    }

    private static void handleBanking(Klient klient, Banker banker) {
        System.out.println("Хотите обратиться к банкиру за кредитом? (Y/N)");
        if (!getYesOrNo()) {
            System.out.println("Доброго дня!");
            return;
        }

        if (!banker.chekDuty(klient.getDuty())) {
            System.out.println("Кредит отклонен. Погасите текущий долг.");
            System.out.println("Хотите погасить долг сейчас? (Y/N)");
            if (getYesOrNo()) {
                banker.getDuty(klient);
                klient.getBasket().clearBasket();
            } else {
                System.out.println("Доброго дня!");
                klient.getBasket().clearBasket();
            }
            return;
        }

        System.out.println("Введите сумму кредита (процент 10%):");

        String strId = new Scanner(System.in).nextLine();

        if(!strId.matches("\\d+"))
        {
            System.out.println("Не верные данные!");
            klient.getBasket().clearBasket();
            return;
        }

        if(strId.length() > 5)
        {
            System.out.println("Вам отказано!");
            klient.getBasket().clearBasket();
            return;
        }

        double amount = Double.parseDouble(strId);
        double resultAmount = banker.giveAmout(amount);

        if (resultAmount == 0) {
            System.out.println("Вам отказано!");
            klient.getBasket().clearBasket();
        } else {
            klient.plusBalance(amount);
            klient.plusDuty(amount);
            System.out.println("Кредит одобрен! Ваш баланс: " + klient.getBalance() + " $");
            klient.getBasket().clearBasket();
        }
    }

    private static boolean getYesOrNo() {
        while (true) {
            char ch = new Scanner(System.in).next().charAt(0);
            if (ch == 'Y' || ch == 'y') return true;
            if (ch == 'N' || ch == 'n') return false;
            System.out.println("Введите Y (да) или N (нет):");
        }
    }

    private static String getUserChoice(String option1, String option2) {
        while (true) {
            String choice = new Scanner(System.in).nextLine();
            if (choice.equals(option1) || choice.equals(option2)) return choice;
            System.out.println("Введите " + option1 + " или " + option2 + ":");
        }
    }
}

