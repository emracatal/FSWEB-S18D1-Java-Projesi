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
public class BurgerDaoImpl implements BurgerDao {
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
        return Optional.ofNullable(entityManager.find(Burger.class, id));
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByPrice(Double price) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.price >= :price ORDER BY b.price desc", Burger.class);
        query.setParameter("price", price);
        return query.getResultList();
    }


    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query=entityManager.createQuery("SELECT b FROM Burger b WHERE b.breadType = :breadType ORDER BY b.name asc",Burger.class);
        query.setParameter("breadType",breadType);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.contents like CONCAT ('%',:content,'%') ORDER BY name", Burger.class);
        query.setParameter("content",content);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Transactional
    @Override
    public Burger remove(Long id) {
        Optional<Burger> optionalBurger = findById(id);
        //if(optionalBurger.isPresent()){} TODO exceptions sonrası
        entityManager.remove(optionalBurger.get());
        return optionalBurger.get();
    }


}
