package com.stepanov.d;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        DBWorker worker = new DBWorker();

        String query = "select * from userstable";

        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                /*
                    TODO: check git
                    new changes!!!
                    1
                    2
                    new in APP-97
                    TODO: this is APP-97
                    my change
                */

                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
