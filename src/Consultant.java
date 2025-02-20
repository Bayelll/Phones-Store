public class Consultant
{
    private static int size = 0;

    public boolean search(int id, Store store, Klient klient)
    {

        if(store.Phones(id, this))
        {
            Phones phone = store.add(id, this);

            if(phone != null)
            {
                klient.setPhone(phone);
            }
        }

        return store.Phones(id, this);
    }
}
