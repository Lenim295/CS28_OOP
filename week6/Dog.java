package week6;

public class Dog extends Animal {
    public Dog(String name) {
        super(name); // เรียก constructor ของ superclass (Animal) เพื่อกำหนดค่า name
    }

    @Override
    public void makeSound() {
        System.out.println(name + " say : hong hong!");
    }
    
    public void run() {
        System.out.println(name + " is running.");
    }
}
