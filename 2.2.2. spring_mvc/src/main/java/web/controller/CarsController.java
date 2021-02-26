package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private final CarService service;

    private List<Car> cars;

    public CarsController(CarService service) {
        this.service = service;
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam(required = false) Integer count) {
        int intCount = count == null ? 5 : count;
        List<String> messages = service.getCarStrings(intCount);
        model.addAttribute("messages", messages);
        return "cars";
    }
}
