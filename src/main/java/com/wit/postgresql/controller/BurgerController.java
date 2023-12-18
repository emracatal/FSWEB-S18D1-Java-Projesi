package com.wit.postgresql.controller;

import com.wit.postgresql.dao.BurgerDao;
import com.wit.postgresql.entity.Burger;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Burger savedBurger=burgerDao.save(burger);
        return savedBurger;
    }

    @GetMapping("/")
    public List<Burger> findAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable Long id) {
        Optional<Burger> burger=burgerDao.findById(id);
        //if(burger.isPresent()){ //globalexceptions sonrası bunu yazıcaz
            return burger.get();
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable Long id) {
        return burgerDao.remove(id);
    }
}
