package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private List<Car> cars;

    private void init() {
        cars = new ArrayList<>();
        cars.add(new Car("BMW", "X5", 2015));
        cars.add(new Car("Peugeot", "308", 2013));
        cars.add(new Car("Ford", "Mondeo", 2010));
        cars.add(new Car("Tesla", "Model S", 2019));
        cars.add(new Car("Lada", "Vesta", 2018));
    }

    private List<String> getCarStrings(int count) {
        if (count >= 5 || count >= cars.size()) {
            count = cars.size();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Car car = cars.get(i);
            String carString = String.format("Brand: %s, model: %s, year: %d",
                    car.getBrand(), car.getModel(), car.getYear());
            result.add(carString);
        }
        return result;
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam(required = false) Integer count) {
        init();
        int intCount = count == null ? 5 : count;
        List<String> messages = getCarStrings(intCount);
        model.addAttribute("messages", messages);
        return "cars";
    }
}
