Mini Store - Java JDBC + Existing SQLite .db file

1. Extract the ZIP. Open the MiniStore_SQLite_DirectDB folder as a Maven project in NetBeans.
2. The REAL database file ministore.db is included at project root and contains 5 sample products.
3. Open this exact file in DB Browser for SQLite (Open Database). Do not create another database.
4. Maven downloads org.xerial:sqlite-jdbc automatically when online.
5. Run com.example.ministore.Main or use: mvn compile exec:java
6. Select menu 1 to view products, and menu 6 to sell and deduct stock.
7. In DB Browser, use Browse Data and Refresh to inspect changes. Avoid uncommitted DB Browser transactions while Java is running.

IMPORTANT: DBConnection uses user.dir/ministore.db and checks the file exists.
In NetBeans, if the database file cannot be found, set Run working directory to project root, or adjust DB_FILE to the absolute path of your .db file.
To reset sample data, delete ministore.db and create a new one in DB Browser, then run sql/setup.sql and Write Changes.
