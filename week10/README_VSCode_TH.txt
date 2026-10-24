MiniStore Java + SQLite JDBC — สำหรับ VS Code

ภายในมีไฟล์ ministore.db จริงพร้อมข้อมูลตัวอย่าง และ Maven pom.xml กำหนด SQLite JDBC dependency (org.xerial:sqlite-jdbc 3.46.1.3) ไว้แล้ว

สิ่งที่ต้องมี: JDK 17 ขึ้นไป, VS Code, Extension Pack for Java และ Maven for Java

วิธีใช้
1. แตก ZIP และเปิด VS Code > File > Open Folder > MiniStore_SQLite_VSCode_JDBC (โฟลเดอร์ที่มี pom.xml)
2. VS Code จะตรวจพบ Maven project และดาวน์โหลด JDBC driver พร้อม dependencies อัตโนมัติเมื่อมีอินเทอร์เน็ต (ครั้งแรก)
3. รอ Java Projects / Maven Dependencies โหลดเสร็จ
4. เปิด src/main/java/com/example/ministore/Main.java แล้วกด Run หรือ Run and Debug > Run MiniStore (SQLite)
5. เลือกเมนู 1 ดูสินค้า / 2 เพิ่ม / 3 ค้นหา / 4 แก้ไข / 5 ลบ / 6 ขาย
6. เปิด ministore.db ใน DB Browser for SQLite เพื่อดูผล (Refresh หลัง Java แก้ไข)

หมายเหตุสำคัญ
- ZIP นี้ไม่ได้บรรจุไฟล์ sqlite-jdbc.jar จริง เพราะไม่สามารถดาวน์โหลดไลบรารีในสภาพแวดล้อมสร้างไฟล์ได้ แต่ได้กำหนด JDBC driver ใน pom.xml แล้ว; VS Code/Maven จะดาวน์โหลดให้ครั้งแรกเมื่อออนไลน์
- DBConnection.java ชี้ไฟล์ ministore.db ที่ root โปรเจกต์และตรวจว่ามีไฟล์อยู่ก่อนเชื่อมต่อ
- อย่าเปิด DB Browser ค้างพร้อมธุรกรรมที่ยังไม่ได้ Write Changes เพราะอาจเกิด database is locked
- ถ้า VS Code ไม่พบ JDBC: เช็ค Maven Dependencies และสั่ง Java: Clean Java Language Server Workspace แล้ว Reload
- หาก Run Code ของส่วนขยาย Code Runner ไม่ใช้ classpath Maven ให้รันผ่านปุ่ม Run Java ของ Extension Pack for Java หรือ Maven exec:java
- ใช้ JDK 17+ และ Maven (หากรันผ่าน command line: mvn compile exec:java)

ตาราง: products(id,code,name,price,stock)
