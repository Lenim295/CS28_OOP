package week4;

public class BankAccount {
    //เป็น private เพราะไม่ต้องการให้เข้าถึงโดยตรง ต้องเข้าถึงผ่าน method ของ class เท่านั้น
    // ป้องกันไม่ให้มีการแก้ไขข้อมูลโดยตรง
    private String accountNo;
    private String ownerName;
    private double balance;
    private int pin;
    
    public BankAccount(String accountNo, String ownerName, double balance, int pin) {
        this.accountNo = accountNo;
        this.ownerName = ownerName;
        this.balance = balance;
        this.pin = pin;
    }
    
    public boolean checkPin(int inputPin) {
    return this.pin == inputPin;  
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if( amount > 0) {
            balance += amount;
            System.out.println("ฝากเงินสำเร็จ" + amount + " บาท");
        }
        else {
            System.out.println("จำนวนเงินฝากไม่ถูกต้อง");
        }
    }

    public void withdraw(double amount) {
        // ตรวจสอบว่าจำนวนเงินที่ถอนมากกว่า 0 และไม่เกินยอดเงินคงเหลือในบัญชี
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("ถอนเงินจำนวน" + amount + "บาท สำเร็จ!!");
        }
        else {
            System.out.println("จำนวนเงินถอนไม่ถูกต้อง");
        }
    }

    public void showInfo() {
        System.out.println("ข้อมูลสถานะบัญชี");
        System.out.println("เลขที่บัญชี : " + accountNo);
        System.out.println("ชื่อเจ้าของบัญชี : " + ownerName);
        System.out.println("ยอดเงินคงเหลือ : " + balance);
    }

    // รับ BankAccount ปลายทางเข้ามาเป็น parameter
    public void transfer(double amount, BankAccount target) {
    if (amount <= 0) {
        System.out.println("จำนวนเงินไม่ถูกต้อง");
        return;
    }
    if (amount > balance) {
        System.out.println("ยอดเงินไม่เพียงพอ");
        return;
    }
    // ถอนจากบัญชีตัวเอง
    balance -= amount;
    // ฝากเข้าบัญชีปลายทาง
    target.deposit(amount);
    System.out.println("โอนเงินสำเร็จ");
}
}
