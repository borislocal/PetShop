package animal.model;

public class Dog extends Mammal {

    long animalId;
    double price;
    String name;

    public Dog(long animalId, double price, String name) {
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

    @Override
    public void feedWithMilk() {

    }


    public void bark() {
        System.out.println("Woof!");

    }

    public Dog(Color color) {

    }

    public Dog(String command) {
        bark();
    }

    public Dog() {
        bark();
    }

    //overloaded:
    public void bark(String string) {
    }

    public String bark(Integer i) {
        return null;
    }

}