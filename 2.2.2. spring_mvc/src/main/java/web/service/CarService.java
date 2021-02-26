package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

public interface CarService {
    void add(Car car);
    List<Car> listAll();

    List<String> getCarStrings(int count);
}
