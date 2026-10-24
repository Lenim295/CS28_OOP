package week6;

public class Main {
    
    public static void main(String[] args) {
        
        Dog dog = new Dog("Fido");
        dog.eat();
        dog.makeSound();
        dog.run();

        Cat cat = new Cat("TP");
        cat.eat();
        cat.makeSound();
        cat.scratch();

        Bird bird = new Bird("Sunday");
        bird.eat();
        bird.makeSound();
        bird.fly();
    }
}