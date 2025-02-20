public class Store
{
    private Cashier cashier; // Кассир
    private Consultant consultant; // Консультант
    private Products products; // Продукты
    private Banker banker; // Банкир

    private Phones[] phones = {
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "14", "Черный", 128, 6, 999.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "14 Pro", "Синий", 256, 6, 1099.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "14 Pro Max", "Белый", 512, 6, 1199.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "15", "Красный", 128, 6, 999.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "15 Plus", "Фиолетовый", 256, 6, 1099.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "15 Pro", "Серый", 512, 8, 1299.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "15 Pro Max", "Золотой", 1024, 8, 1399.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "13", "Черный", 128, 4, 799.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "13 Pro", "Синий", 256, 6, 999.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "13 Pro Max", "Белый", 512, 6, 1099.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "SE", "Красный", 128, 4, 499.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "12", "Фиолетовый", 256, 4, 699.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "12 Pro", "Золотой", 512, 6, 999.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "12 Pro Max", "Серый", 1024, 6, 1099.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "11", "Черный", 128, 4, 599.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "11 Pro", "Белый", 256, 4, 899.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "11 Pro Max", "Красный", 512, 4, 999.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "XR", "Желтый", 128, 3, 499.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "XS", "Серый", 256, 4, 899.99),
            new Phones(10000000 + (int) (Math.random() * (90000000)), "iPhone", "XS Max", "Золотой", 512, 4, 999.99)

    };

    public boolean Phones(int id, Consultant consultant)
    {
        for (Phones phone : phones) {
            if (phone.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Phones add(int id, Consultant consultant)
    {
        for (Phones phone : phones) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }


    public void printPhones() {
        System.out.printf("%-10s %-20s %-20s %-10s %-10s %-10s %-10s%n",
                "ID", "Model", "Title", "Color", "Memory", "RAM", "Price");
        System.out.println("------------------------------------------------------------------------------");

        for (int i = 0; i < phones.length; i++) {

            int id = phones[i].getId();
            String model = phones[i].getModel();
            String title = phones[i].getTitle();
            String color = phones[i].getColor();
            int memory = phones[i].getMemory();
            int ram = phones[i].getRam();
            double price = phones[i].getPrice();

            System.out.printf("%-10d %-20s %-20s %-10s %-10d %-10d $%-10.2f%n",
                    id, model, title, color, memory, ram, price);
        }
    }


}

