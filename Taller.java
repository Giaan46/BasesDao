package com.tokioschool.basedatos.dao;

import com.tokioschool.basedatos.dao.dao.CarDao;
import com.tokioschool.basedatos.dao.domain.Car;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Taller {

private boolean running;
    Scanner keyboard = new Scanner(System.in);

    public Taller(){
        running = true;

    }
    public void launch(){
        do {

        System.out.println("TokioTaller v0.1");
        System.out.println("1. Registrar un vehiculo");
        System.out.println("2. Ver vehiculos regustrados");
        System.out.println("3. Registrar reparacion");
        System.out.println("4. Ver coches disponibles (ya reparados)");
        System.out.println("q. salir");
        System.out.println("Opcion:");
        String choice = keyboard.nextLine();
        switch (choice) {
            case "1":
                addCar();
                break;
            case "2":
                viewCars();

                break;
            case "3":
                repairCar();
                break;
            case "4":
                viewRepairCar();
                break;
            case "q":
                exit();
                break;
            default:
                System.out.println("Opcion incorrecta ");
        }
        }while(running);
    }
    private void addCar(){
        System.out.println("Modelo: ");
        String model = keyboard.nextLine();
        System.out.println("Color: ");
        String color = keyboard.nextLine();
        System.out.println("Velocidad maxima: ");
        int maxSpeed = Integer.parseInt(keyboard.nextLine());
        System.out.println("Peso: ");
        float weigth = Float.parseFloat(keyboard.nextLine());
        System.out.println("Averia: ");
        String damage =  keyboard.nextLine();

        Car car = new Car(model,color,maxSpeed,weigth,damage);
        try {
            CarDao carDao = new CarDao();
            carDao.addCar(car);
            System.out.println("Coche registrado correctamente.");
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
    private void viewCars(){
        try {
            CarDao carDao = new CarDao();
            List<Car> allCars = carDao.getCars();
            allCars.forEach(System.out::println);
        }catch (SQLException sqle){
            sqle.printStackTrace();

        }
    }
    private void repairCar(){

    }
    private void viewRepairCar(){
        try {
            CarDao carDao = new CarDao();
            List<Car> repairedCars = carDao.getRepairCars();
        }catch (SQLException sqle){
            sqle.printStackTrace();

        }
    }
    private void exit(){
        running =  false;
    }
}
