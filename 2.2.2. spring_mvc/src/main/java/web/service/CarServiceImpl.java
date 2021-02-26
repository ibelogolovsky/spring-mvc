package web.service;

import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarDao dao;

    public CarServiceImpl(CarDao dao) {
        this.dao = dao;
    }

    @PostConstruct
    private void postConstruct() {
        add(new Car("BMW", "X5", 2015));
        add(new Car("Peugeot", "308", 2013));
        add(new Car("Ford", "Mondeo", 2010));
        add(new Car("Tesla", "Model S", 2019));
        add(new Car("Lada", "Vesta", 2018));

    }

    @Override
    public void add(Car car) {
        dao.add(car);
    }

    @Override
    public List<Car> listAll() {
        return dao.listAll();
    }

    @Override
    public List<String> getCarStrings(int count) {
        List<Car> cars = dao.listAll();
        cars = cars.subList(0, Math.min(count, cars.size()));
        return cars.stream().map(car -> String.format("Brand: %s, model: %s, year: %d",
                car.getBrand(), car.getModel(), car.getYear())).collect(Collectors.toList());
    }
}
