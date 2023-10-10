package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = new CarServiceImpl();
    }

    @GetMapping
    public String getCar(@RequestParam(value = "count", defaultValue = "5") int num, Model model) {
        List<Car> car = carService.printCar(num);
        model.addAttribute("count", car);
        return "cars";
    }
}
