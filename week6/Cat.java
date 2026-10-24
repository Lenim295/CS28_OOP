package week6;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " say : meow meow!");
    }
    
    public void scratch() {
        System.out.println(name + " is scratching.");
    }
    
}
