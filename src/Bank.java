public class Bank
{
    private double balance = 7000;

    public boolean checkGive(double amount)
    {
        return balance - amount > 5000;
    }

    public void plusBalance(double amount)
    {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
