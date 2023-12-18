package com.wit.postgresql.controller;

import com.wit.postgresql.dao.BurgerDao;
import com.wit.postgresql.entity.BreadType;
import com.wit.postgresql.entity.Burger;
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
    public List<Burger> findAll() {
        return burgerDao.findAll();
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
    public Burger update(@RequestBody Burger burger) {
        return burgerDao.update(burger);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable Double price) {
        return burgerDao.findByPrice(price);
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
