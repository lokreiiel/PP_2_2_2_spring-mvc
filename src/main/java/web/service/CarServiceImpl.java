package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> printCar(int num) {
        List<Car> car = new ArrayList<>();
        car.add(new Car(1999, "black", 20));
        car.add(new Car(2002, "white", 100));
        car.add(new Car(2012, "yellow", 30));
        car.add(new Car(1987, "red", 200));
        car.add(new Car(2005, "orange", 70));
        if (num == 0 || num > 5) {
            return car;
        }
        return car.stream().limit(num).collect(Collectors.toList());
    }

}
