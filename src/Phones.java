public class Phones
{
    private int id;
    private String model;
    private String title;
    private String color;
    private int memory;
    private int ram;
    private double price;

    public Phones(int id, String model, String title, String color, int memory, int ram, double price) {
        this.id = id;
        this.model = model;
        this.title = title;
        this.color = color;
        this.memory = memory;
        this.ram = ram;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return color;
    }

    public int getMemory() {
        return memory;
    }

    public int getRam() {
        return ram;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
