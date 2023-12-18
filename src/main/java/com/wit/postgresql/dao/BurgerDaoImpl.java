package com.wit.postgresql.dao;

import com.wit.postgresql.entity.BreadType;
import com.wit.postgresql.entity.Burger;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BurgerDaoImpl implements BurgerDao{
    private EntityManager entityManager;

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional//hata olursa herşeyi geri alması için
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Optional<Burger> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Burger.class,id));
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query=entityManager.createQuery("SELECT b FROM Burger b",Burger.class);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByPrice(Double price) {
        return null;
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        return null;
    }

    @Override
    public List<Burger> findByContent(String content) {
        return null;
    }

    @Override
    public Burger update(Burger burger) {
        return null;
    }

    @Transactional
    @Override
    public Burger remove(Long id) {
        Optional<Burger> optionalBurger=findById(id);
        //if(optionalBurger.isPresent()){} TODO exceptions sonrası
        entityManager.remove(optionalBurger.get());
        return optionalBurger.get();
    }
}
