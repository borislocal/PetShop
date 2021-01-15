package animal.model;

import java.util.Objects;

public class Cat extends Animal implements MilkFeedable {

    private long animalId;

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

    private double price;
    private String name;


    public Cat(long animalId, double price, String name) {
        this.animalId = animalId;
        this.price = price;
        this.name = name;
    }

    public Cat() {
    }

    public void feedWithMilk() {
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {

            return true;
        } else if (object == null || object.getClass() != this.getClass()) {

            return false;
        } else if (this.name.equals(((Cat) object).name)) {

            return true;
        } else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
