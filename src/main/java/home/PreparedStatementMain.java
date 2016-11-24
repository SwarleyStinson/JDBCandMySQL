package home;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class PreparedStatementMain {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbserver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";

    private static final String INSERT_NEW = "INSERT INTO dish VALUES (?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM dish";

    public static void main(String args[]) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
//          Создаем драйвер для MySQL и регистрируем его в DriverManager
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

//          Создаем соединение (connection)
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(GET_ALL);

//          Получаем все поля ResultSet, выполняя SQL-запрос

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                float rating = resultSet.getFloat("rating");
                boolean published = resultSet.getBoolean("published");
                Date created = resultSet.getDate("created");
                byte[] icon = resultSet.getBytes("icon");

                System.out.println("id: " + id + ", title: " + title + ", description: " + description
                        + ", rating: " + rating + ", published: " + published + ", created: " + created +
                        ", size: " + icon.length);
            }

//            1# Создание и выполнение preparedStatement

//            preparedStatement.setInt(1, 3);
//            preparedStatement.setString(2, "Inserted title");
//            preparedStatement.setString(3, "Inserted description");
//            preparedStatement.setFloat(4, 0.2f);
//            preparedStatement.setBoolean(5, true);
//            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
//            preparedStatement.setBlob(7, new FileInputStream("pied_piper.png"));
//
//            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}