## Dördüncü hafta ödevi son teslim tarihi : 06.08.2021(Gelecek hafta pazartesi) - Saat =>  23:30

![homework](https://user-images.githubusercontent.com/45206582/131386439-6727321a-5a50-4c20-9413-ea4013013434.PNG)

##Modeller (Entity)

* Student
* Instructor
* Course
 
-> Toplam da 3 adet model vardır. Controller üzerinde response ve request işlemleri DTO kapsamında gerçekleştirilmiştir.

-> Instructor~Course arasında **OneToMany** ilişkisi - Student~Course arasında **ManyToMany** ilişkisi bulunmaktadır.

## Nasıl kullanabilirim ? 
 
* Cloneladıktan sonra veritabanı oluşturmaya gerek duymaksızın **localhost:8080/[swagger-ui](http://localhost:8080/swagger-ui.html)** şeklinde endpointlere erişim sağlanabilir. 
 
* Database erişimi için **localhost:8080/[h2-console](http://localhost:8080/h2-console/)** diyerek in memory database yapısına erişim sağlanır. 

* **application.yml** içinde ki configurasyon ayarları isteye bağlı değiştirilebilir veya düzenlenebilir.


## Kullanılan Teknolojiler

- Spring Boot
- Spring Web + Data Jpa
- Lombok
- Swagger UI
- H2 Database
- MapStruct

### - Sistemde aynı telefon numarasına sahip 2 ayrı eğitmen bulunamaz.
![](screenshots/Ekran%20Resmi%202021-09-12%2016.11.02.png)
---
### - Sistemde aynı ders koduna sahip 2 ayrı ders olamaz.
![](screenshots/Ekran%20Resmi%202021-09-12%2016.09.37.png)
---
### - Öğrenci yaşı 18’den küçük, 40’tan büyük olamaz.
![](screenshots/Ekran%20Resmi%202021-09-12%2016.09.37.png)
---
### - Bir dersi aynı anda en fazla 20 öğrenci alabilir. 21. öğrenci eklendiğinde bu hata ile karşılaşılır.
![](screenshots/Ekran%20Resmi%202021-09-12%2016.12.50.png)
---
### - İşlenen Hataların Database Kayıtları
![](screenshots/Ekran%20Resmi%202021-09-12%2016.13.49.png)
