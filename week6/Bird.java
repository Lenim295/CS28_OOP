package week6;
// ใช้ implement interface Flyable
public class Bird extends Animal implements Flyable {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " say : jeeb jeeb!");
    }
    // implement method fly() จาก interface Flyable
    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }
}

