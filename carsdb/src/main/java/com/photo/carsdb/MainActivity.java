package com.photo.carsdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DataBaseHandler;
import Model.Car;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHandler dataBaseHandler=new DataBaseHandler(this);
//        dataBaseHandler.addCar(new Car("Toyota","3000 $"));
//        dataBaseHandler.addCar(new Car("BMW","8000 $"));
//        dataBaseHandler.addCar(new Car("Opel","2500 $"));
//        List<Car> carList=dataBaseHandler.getAllCars();
//        for (Car car:carList){
//            Log.d("Car info","id"+car.getId()+": carName"+car.getName()+"  price:"+car.getPrice());
//        }
        Car car=dataBaseHandler.getCar(1);

        car.setName("Tesla");
       car.setPrice("8000000$");
       dataBaseHandler.updateCar(car);
        Log.d("Car info","id"+car.getId()+": carName"+car.getName()+"  price:"+car.getPrice());
    }
}
