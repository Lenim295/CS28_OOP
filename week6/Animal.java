package week6;
//class แม่แบบแต่ไม่ได้สร้าง object ได้
public abstract class Animal {
    protected String name; // subclass เข้าถึงได้โดยตรง

    public Animal(String name) {
        this.name = name;
    }
    // subclass ทุกตัวต้องเขียนเพิ่มเอง makeSound() method ไม่งั้นจะ error
    // สังเกตุได้จากไม่มี {}
    public abstract void makeSound();

    public void eat() {
        System.out.println(name + " is eating.");
    }
}