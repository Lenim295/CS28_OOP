package week2;

public class Car {
    // สร้างตัวแปร global ของ Class Car (field)
    String Brand;
    int speed;
    // สำหรับสร้าง Constructor(object) ของ Class Car
    //method พิเศษที่รันอัตโนมัติทันทีที่ new Car(...) ถูกเรียก มีกฎเดียวคือชื่อต้องตรงกับชื่อ class
    public Car(String Brand, int speed) {
        this.Brand = Brand;
        this.speed = speed;
    }
    // เทียบเท่า if __name__ == '__main__': main() ของ python
    public static void main(String[] args) {
        // local variable 
        String Brand = "...Honda...";
        int speed = 120;
        //Car แรกคือบอกว่าจะเรียกใช้ object ที่สร้างไว้ตอนแรก  ส่วน car 2 อันนี้คือชื่อตัวแปรเฉยๆ ส่วน new Car() คือส่วนที่สร้าง object จริงๆ
        Car car = new Car(Brand, speed);
        System.out.println("test");
        car.carBrand();
        car.carEngineStart();
        car.carDrive();
        car.carEngineStop();
    }

    void carBrand() {
        System.out.println("Car Brand is" + Brand);
    }
    void carEngineStart() {
        System.out.println("Car Engine Started");
    }

    void carDrive() {
        System.out.println("Car is Driving at " + speed + " km/h");
    }
    
    void carEngineStop() {
        System.out.println("Car Engine Stopped");
    }

}
