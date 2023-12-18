CODEPAN HTML;
<button id="click">LIST HAMBURGERS</button>
<div id="burgerList"></div>

CODEPAN JS;
const button=document.getElementById("click");
const burgerListDiv = document.getElementById("burgerList");

button.addEventListener("click",()=>{
burgerListDiv.innerHTML = '';
fetch("http://localhost:9000/workintech/burgers/").then(result => {
result.json().then(response => {
// Her bir hamburger için <p> elementi oluştur
response.forEach(hamburger => {
const paragraph = document.createElement("p");
paragraph.textContent = `${hamburger.name} - ${hamburger.price} TL`;
burgerListDiv.appendChild(paragraph);
});
});
})
.catch(error => {
console.error("Error fetching data:", error);
});
});

POSTMAN;
[GET]/workintech/burgers => tüm burger listini dönmeli.
[GET]/workintech/burgers/{id} => İlgili id deki burger objesini dönmeli.
[POST]/workintech/burgers => Bir adet burger objesini veritabanına kaydeder.
[PUT]/workintech/burgers/{id} => İlgili id deki burger objesinin değerlerini yeni gelen data ile değiştirir.
[DELETE]/workintech/burgers/{id} => İlgili id değerindeki burger objesini veritabanından siler.
[GET]/workintech/burgers/findByPrice => RequestBody'de price değerini alır ve BurgerDaoImpl sınıfındaki findByPrice metodunu çağırır.
[GET]/workintech/burgers/findByBreadType => RequestBody'de breadType değerini alır ve BurgerDaoImpl sınıfındaki findByBreadType metodunu çağırır.
[GET]/workintech/burgers/findByContent => RequestBody'de content değerini alır ve BurgerDaoImpl sınıfındaki findByContent metodunu çağırır.
http://localhost:9000/workintech/burgers/

