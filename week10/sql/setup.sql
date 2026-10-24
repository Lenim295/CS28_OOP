CREATE TABLE IF NOT EXISTS products (
 id INTEGER PRIMARY KEY AUTOINCREMENT,
 code TEXT UNIQUE NOT NULL,
 name TEXT NOT NULL,
 price REAL NOT NULL CHECK(price >= 0),
 stock INTEGER NOT NULL CHECK(stock >= 0)
);
INSERT OR IGNORE INTO products(code,name,price,stock) VALUES
('P001','Keyboard',850,10),('P002','Mouse',350,15),('P003','Monitor',4500,5),('P004','Webcam',1200,8),('P005','Speaker',990,6);
