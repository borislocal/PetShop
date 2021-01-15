package animal.model;

public abstract class Animal {

    private long animalId;
    private double price;
    private String name;

    public Animal(long animalId, double price, String name) {
        this.name = name;
        this.price = price;
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    void eat() {

    }

    void breathe() {

    }

    public Animal() {
    }
//
//    public Animal(Color color) {
//        switch (color) {
//            case BLACK:
//            case WHITE:
//                System.out.println("look, this creature is " + color.name());
//                break;
//            default:
//                System.out.println("Look, this creature has indigo color!");
//        }
//    }

}
