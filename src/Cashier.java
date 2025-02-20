public class Cashier
{
    public boolean checkBalance(double balance, Klient klient)
    {
        return !(balance < klient.getBasket().getPrice());
    }

    public void minusPrice(Klient klient)
    {
        klient.minusBalance(klient.getBasket().getPrice());
    }
}
