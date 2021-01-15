package animal.model;

public class Parrot extends Animal implements Flyable {

    private long animalId;
    private double price;
    private String name;

    public Parrot(long animalId, double price, String name) {
        this.animalId = animalId;
        this.price = price;
        this.name = name;
    }

    @Override
    public long getAnimalId() {
        return animalId;
    }

    @Override
    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void fly() {
        System.out.println("помогите, меня превратили в попугая");
    }
}
