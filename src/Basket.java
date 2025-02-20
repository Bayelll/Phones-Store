import java.util.Arrays;

public class Basket
{
    private static int size = 0;

    private Phones[] phones;

    public Basket() {
        phones = new Phones[100]; // Задаем размер массива
    }

    public void setPhones(Phones phone) {
        phones[size] = phone;
        size++;
    }

    public void printBasket() {
        // Заголовок таблицы
        System.out.printf("%-20s %-20s %-10s %-10s %-10s %-10s%n",
                "Model", "Title", "Color", "Memory", "RAM", "Price");
        System.out.println("------------------------------------------------------------------------------");

        // Цикл по массиву телефонов в корзине
        for (int i = 0; i < phones.length; i++) {
            if (phones[i] != null) { // Проверка на наличие телефона
                // Получение данных о телефоне
                String model = phones[i].getModel();
                String title = phones[i].getTitle();
                String color = phones[i].getColor();
                int memory = phones[i].getMemory();
                int ram = phones[i].getRam();
                double price = phones[i].getPrice();

                // Вывод данных о телефоне в таблице
                System.out.printf("%-20s %-20s %-10s %-10d %-10d $%-10.2f%n",
                        model, title, color, memory, ram, price);
            }
        }
        System.out.println("------------------------------------------------------------------------------");
    }

    public void clearBasket()
    {
        Arrays.fill(phones, null);
    }

    public boolean isEmpty()
    {
        boolean empty = true;

        for (Phones phone : this.phones) {
            if (phone != null)
            {
                empty = false;
                break;
            }
        }

        return empty;
    }

    public double getPrice()
    {
        double price = 0;
        for (Phones phone : this.phones) {
            if (phone != null)
            {
                price += phone.getPrice();
            }
        }

        return price;
    }

}
