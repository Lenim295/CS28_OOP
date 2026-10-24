package week10.src.main.java.com.example.ministore;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Open the same ministore.db file in DB Browser for SQLite.
    private static final Path DB_FILE = Path.of(System.getProperty("user.dir"), "ministore.db")
            .toAbsolutePath().normalize();

    public static Connection getConnection() throws SQLException {
        if (!Files.isRegularFile(DB_FILE)) {
            throw new SQLException("Database file not found: " + DB_FILE
                    + " (set the project working directory to the folder containing ministore.db)");
        }
        return DriverManager.getConnection("jdbc:sqlite:" + DB_FILE);
    }
}
