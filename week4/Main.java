package week4;
//import เพื่อเรียกใช้ class Scanner สำหรับรับ input จากผู้ใช้
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  pinCode;
        String menu ,accountNo;
        //input
        System.out.println("กรุณากรอกเลขบัญชี: ");
        accountNo = sc.nextLine(); 
        System.out.println("กรุณากรอก PIN: ");
        pinCode = sc.nextInt();
        //สร้าง object ของ class BankAccount โดยใช้ accountNo และ pinCode ที่ผู้ใช้ป้อนเข้ามา
        BankAccount account = new BankAccount("54321", "Lenim", 5000, 12345);

        ADM adm = new ADM(account);
        //เช็คจาก ADM ว่าถูกต้องหรือไม่ โดยเรียกใช้ method checkAccount ของ class ADM
        if (adm.checkAccount(accountNo, pinCode) == true) {
        //do ไปเรื่อยๆ(loop) จนกว่าจะเลือกเมนู 0(while) เพื่อออกจากระบบ
            do {
                System.out.println("-------------Welcome to ADM System" +" " + account.getOwnerName() + "-------------");
                System.out.println("1. แสดงข้อมูลบัญชี");
                System.out.println("2. ฝากเงิน");
                System.out.println("3. ถอนเงิน");
                System.out.println("4. ตรวจสอบยอดเงินคงเหลือ");
                System.out.println("5. โอนเงินไปยังบัญชีอื่น");
                System.out.println("Q. ออกจากโปรแกรม");
                System.out.println("เลือกเมนู");
                //รับ input จากผู้ใช้เพื่อเลือกเมนู
                menu = sc.next();

                if (menu.equals("1")) {
                    adm.showInformation();
                } 
                else if (menu.equals("2")) {
                    System.out.println("ระบุจำนวนเงินที่ต้องการฝาก: ");
                    double amount = sc.nextDouble();
                    adm.depositMoney(amount);
                } 
                else if (menu.equals("3")) {
                    System.out.println("ระบุจำนวนเงินที่ต้องการถอน: ");
                    double amount = sc.nextDouble();
                    adm.withdrawMoney(amount);
                } 
                else if (menu.equals("4")) {
                    adm.checkBalance();
                } 
                else if (menu.equals("5")) {
                    System.out.println("กรอกเลขบัญชีปลายทาง: ");
                    String targetNo = sc.next();   // รับเลขบัญชีจาก user

                    if (targetNo.equals("99999")) {
                        // สร้าง object ของบัญชีปลายทาง
                        BankAccount targetAccount = new BankAccount("99999", "สมชาย", 0, 0);
                        System.out.println("ระบุจำนวนเงินที่ต้องการโอน: ");
                        double amount = sc.nextDouble();
                        adm.transferMoney(amount, targetAccount);
                    } else {
                        System.out.println("ไม่พบเลขบัญชี " + targetNo + " ในระบบ");
                    }  
                }   
                else if (menu.equals("Q") || menu.equals("q")) {
                    System.out.println("ออกจากระบบเรียบร้อยแล้ว");
                } 
                else {
                    System.out.println("เลือกเมนูไม่ถูกต้อง");
                }
            } 
            while (!menu.equals("Q") && !menu.equals("q"));
            sc.close();
        } else {
            System.out.println("ชื่อบัญชีหรือรหัสผ่านไม่ถูกต้อง");
        }
           
    }
}
