package week4;

public class ADM {
    //BankAccount สามารถเข้าถึง method ของ class BankAccount ได้เพราะเป็น public 
    //แต่ไม่สามารถเข้าถึง field(ตัวแปร) ของ class BankAccount ได้เพราะเป็น private 
    //ดังนั้นต้องเข้าถึงผ่าน method ของ class BankAccount เท่านั้น(ถ้าจะแก้ไขข้อมูล)
    private BankAccount account;
    
    public ADM(BankAccount account) {
        this.account = account;
    }

    public void checkBalance() {
        System.out.println("ยอดเงินคงเหลือ: " + account.getBalance() + "บาท"); //เชื่อมไปยัง method อื่น checkBalance ของไฟล์ BankAccount
    }

    public void depositMoney(double amount) {
        account.deposit(amount); //เชื่อมไปยัง method อื่น deposit ของ BankAccount
    }

    public void withdrawMoney(double amount) {
        account.withdraw(amount); //เชื่อมไปยัง method อื่น withdraw ของ BankAccount
    }

    public void showInformation() {
        account.showInfo(); //เชื่อมไปยัง method อื่น showInfo ของ BankAccount
    }

    public boolean checkAccount(String accountNo, int pin) {
    return account.checkPin(pin); 
}
    // รับ BankAccount ปลายทางผ่านมาจาก Main
    public void transferMoney(double amount, BankAccount target) {
    account.transfer(amount, target);
}
}