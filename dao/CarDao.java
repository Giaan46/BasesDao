package com.tokioschool.basedatos.dao.dao;

import com.tokioschool.basedatos.dao.domain.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    private Connection connection;

    public CarDao() throws SQLException{
        connect();
    }
    public void connect()throws SQLException {
        String url = "jdbc:sqlite:taller.db";
        connection = DriverManager.getConnection(url);

    }
    public void disconnect() throws SQLException{
        connection.close();

    }

    public void addCar(Car car) throws SQLException{
        String sql = "INSERT INTO cars (model, color, max_speed, weigth, repaired,damage) VALUES "+
                "(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,car.getModel());
        statement.setString(2, car.getColor());
        statement.setInt(3,car.getMaxSpeed());
        statement.setFloat(4,car.getWeigth());
        statement.setBoolean(5,car.isRepaired());
        statement.setString(6,car.getDamage());

        statement.executeUpdate();
    }
    public List<Car> getCars() throws SQLException{
        String sql = "SELECT model, color, max_speed, weigth, repaired, damage FROM cars";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        return getResult(result);
    }

    public List<Car> getRepairCars()throws SQLException{
        String sql = "SELECT model, color, max_speed, weigth, repaired, damage FROM cars WHERE repaired = 1";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        return getResult(result);
    }
    public List<Car> getCarsByColor(String color) throws SQLException{
        String sql = "SELECT model, color, max_speed, weigth, repaired, damage FROM cars WHERE color = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,color);
        ResultSet result = statement.executeQuery();
        return getResult(result);
    }
    private List<Car> getResult(ResultSet result) throws SQLException{
        List<Car> cars = new ArrayList<>();
        while(result.next()){
            Car car = new Car(
                    result.getString(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getFloat(4),
                    result.getBoolean(5),
                    result.getString(6)
            );
            cars.add(car);
        }
        return cars;
    }
    public void repairCar(Car car){

    }
}
