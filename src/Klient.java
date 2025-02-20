public class Klient
{
    private double balance; // Количестов денег на счету

    private  double duty; // Долги

    private Basket basket;


    public void setPhone(Phones phone)
    {
        basket.setPhones(phone);
    }

    public boolean Buy(boolean buy)
    {
        // Покупать товар или нет
        return buy;
    }

    public Klient()
    {
        basket = new Basket();
        balance = 700 + (int) (Math.random() * (2500 - 700 + 1));
    }

    public double getDuty()
    {
        return this.duty;
    }

    public Basket getBasket() {
        return this.basket;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public void minusBalance(double balance)
    {
        this.balance -= balance;
    }

    public void plusBalance(double amount)
    {
        this.balance += amount;
    }

    public  void giveDuty(double duty)
    {
        this.balance -= duty;
    }

    public void plusDuty(double duty)
    {
        this.duty += duty;
    }

    public void dutyMinusBalance(double balance) {
        if (balance > this.duty) {
            this.duty = 0;
        } else {
            this.duty -= balance;
        }
        this.balance = 0;
    }

    public void delDuty()
    {
        this.duty = 0;
    }

}
