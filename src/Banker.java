public class Banker
{
    private Bank bank;

    Banker()
    {
        bank = new Bank();
    }

    public boolean chekDuty(double duty)
    {
        if(duty < 500)
        {
            return true;
        }

        return false;
    }

    public double giveAmout(double amout)
    {
        if(bank.checkGive(amout))
        {
            return amout;
        }

        return 0;
    }


    public boolean getDuty(Klient klient) {
        double duty = klient.getDuty() * 1.10; // Добавляем 10% (проценты)

        if (klient.getBalance() >= duty) { // Должно быть >=, а не >
            klient.giveDuty(duty);
            bank.checkGive(duty);
            bank.plusBalance(duty);
            System.out.println("Долг полностью погашен!");
            klient.getBasket().clearBasket();
            klient.delDuty();
            return true;
        } else {
            System.out.println("Недостаточно средств для полного погашения долга!");
            double balance = klient.getBalance();
            klient.dutyMinusBalance(balance);
            bank.plusBalance(balance);
        }

        return false;
    }


    public double getBalanceBank()
    {
        return  bank.getBalance();
    }
}
