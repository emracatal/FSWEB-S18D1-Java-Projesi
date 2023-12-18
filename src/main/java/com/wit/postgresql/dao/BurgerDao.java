package com.wit.postgresql.dao;

import com.wit.postgresql.entity.BreadType;
import com.wit.postgresql.entity.Burger;

import java.util.List;
import java.util.Optional;

public interface BurgerDao {

    //save => Burger objesi alır ve bunu veritabanı tablosuna yazar.
    Burger save(Burger burger);
    //findById => Integer id değeri alır ve karşılığında veritabanındaki Burger kaydını döner.
    Optional<Burger> findById(Long id);
    //findAll => Hiçbir parametre almaz. Veritabanındaki bütün Burgerleri döner
    List<Burger> findAll();
    //findByPrice => price parametresi alır. Aldığı price değerinden daha büyük olan Burgerleri pricelarına göre büyükten küçüğe dogru listeler.
    //TODO conditional search and order by desc
    List<Burger> findByPrice(Double price);
    //findByBreadType => BreadType parametresi alır. Bu parametreye eşit olan breadType tipindeki Burgerleri isimlerine göre alfabetik sırada küçükten büyüğe doğru sıralar
    //TODO order by name asc
    List<Burger> findByBreadType(BreadType breadType);
    //findByContent => Bir adet String değeri alır ve bu değeri contents tablosunda içeren tüm burgerleri döner.
    List<Burger> findByContent(String content);
    //update => Burger objesi alır ve bunu var olan burger objesi ile günceller.
    Burger update(Burger burger);
    //remove => Bir adet id değeri alır ve bu id değerindeki Burger'i siler.
    Burger remove(Long id);


}
