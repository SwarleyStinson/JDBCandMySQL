package com.stepanov.d;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

public class DBWorker {

    private static final String HOST = "jdbc:mysql://localhost:3306/mydbserver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";

    private Connection connection;

    public DBWorker() {
        try {
//          Создаем драйвер для MySQL и регистрируем его в DriverManager
//          Создаем соединение (connection)

            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
