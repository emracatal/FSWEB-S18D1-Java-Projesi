package com.wit.postgresql.controller;

import com.wit.postgresql.dao.BurgerDao;
import com.wit.postgresql.dto.BurgerResponse;
import com.wit.postgresql.entity.BreadType;
import com.wit.postgresql.entity.Burger;
import com.wit.postgresql.util.BurgerResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin("*") //COMMENT BEFORE CLOSE
@RestController
@RequestMapping("/burgers")
public class BurgerController {
    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @PostMapping("/")
    public Burger save(@RequestBody Burger burger) {
        Burger savedBurger = burgerDao.save(burger);
        return savedBurger;
    }

    @GetMapping("/")
    public List<BurgerResponse> findAll() {
        List<Burger> burgers = burgerDao.findAll();
        return BurgerResponseEntity.burgerToBurgerResponse(burgers);
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable Long id) {
        Optional<Burger> burger = burgerDao.findById(id);
        //if(burger.isPresent()){ //globalexceptions sonrası bunu yazıcaz
        return burger.get();
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable Long id) {
        return burgerDao.remove(id);
    }

    @PutMapping("/")
    public BurgerResponse update(@RequestBody Burger burger) {
        Burger updatedBurger= burgerDao.update(burger);
        return new BurgerResponse(updatedBurger.getName(),updatedBurger.getPrice());
    }

    @GetMapping("/price/{price}")
    public List<BurgerResponse> findByPrice(@PathVariable Double price) {
        List<Burger> burgers = burgerDao.findByPrice(price);
        return BurgerResponseEntity.burgerToBurgerResponse(burgers);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }
}
