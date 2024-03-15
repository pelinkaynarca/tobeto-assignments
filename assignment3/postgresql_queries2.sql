--26. Stokta bulunmayan ürünlerin ürün listesiyle birlikte tedarikçilerin ismi ve iletişim numarasını (`ProductID`, `ProductName`, `CompanyName`, `Phone`) almak için bir sorgu yazın.
SELECT p.product_id, p.product_name, p.units_in_stock, s.company_name, s.phone FROM products p
INNER JOIN suppliers s ON p.supplier_id=s.supplier_id
WHERE units_in_stock=0;

--27. 1998 yılı mart ayındaki siparişlerimin adresi, siparişi alan çalışanın adı, çalışanın soyadı
SELECT o.order_id, o.order_date, CONCAT(o.ship_address, ' ', o.ship_city, ' ', o.ship_region, ' ', o.ship_postal_code, ' ', o.ship_country) AS order_address, CONCAT(e.first_name, ' ', e.last_name) AS employee_name FROM orders o
INNER JOIN employees e ON e.employee_id=o.employee_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1998 AND EXTRACT(MONTH FROM o.order_date) = 3
ORDER BY o.order_date;

--28. 1997 yılı şubat ayında kaç siparişim var?
SELECT COUNT(DISTINCT od.order_id) AS "Number of Orders in 1997 Feb" FROM order_details od
INNER JOIN orders o ON o.order_id = od.order_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997 AND EXTRACT(MONTH FROM o.order_date) = 2;

--29. London şehrinden 1998 yılında kaç siparişim var?
SELECT COUNT(DISTINCT o.order_id) FROM orders o
WHERE o.ship_city = 'London' AND EXTRACT(YEAR FROM o.order_date) = 1998;

--30. 1997 yılında sipariş veren müşterilerimin contactname ve telefon numarası
SELECT DISTINCT c.contact_name, c.phone, o.order_date FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997;

--31. Taşıma ücreti 40 üzeri olan siparişlerim
SELECT order_id, freight FROM orders WHERE freight>40;

--32. Taşıma ücreti 40 ve üzeri olan siparişlerimin şehri, müşterisinin adı
SELECT o.freight, o.ship_city, c.contact_name FROM orders o
INNER JOIN customers c ON c.customer_id = o.customer_id
WHERE freight>40;

--33. 1997 yılında verilen siparişlerin tarihi, şehri, çalışan adı -soyadı ( ad soyad birleşik olacak ve büyük harf),
SELECT UPPER(CONCAT(e.first_name, ' ', e.last_name)) AS employee_name, o.order_date, o.ship_city FROM orders o
INNER JOIN employees e ON e.employee_id = o.employee_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997;

--34. 1997 yılında sipariş veren müşterilerin contactname i, ve telefon numaraları ( telefon formatı 2223322 gibi olmalı )
SELECT c.contact_name AS customer_name, REGEXP_REPLACE(c.phone, '[^0-9]', '', 'g') AS formatted_phone FROM customers c
INNER JOIN orders o ON c.customer_id = o.customer_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997
GROUP BY c.customer_id;

-- regexp_replace: 0-9 aralığında, rakam olmayan karakterleri '' yani boş string ile değiştir. 
-- g -> global. aynı durumda olan bütün veriler için aynı şeyi yap.

--35. Sipariş tarihi, müşteri contact name, çalışan ad, çalışan soyad
SELECT o.order_date, c.contact_name AS customer_name, CONCAT(e.first_name, ' ', e.last_name) AS employee_name FROM orders o
INNER JOIN customers c on c.customer_id = o.customer_id
INNER JOIN employees e on e.employee_id = o.employee_id;

--36. Geciken siparişlerim?
SELECT order_id, order_date, required_date, shipped_date FROM orders
WHERE shipped_date > required_date;

--37. Geciken siparişlerimin tarihi, müşterisinin adı
SELECT o.order_id, o.order_date, o.required_date, o.shipped_date, c.contact_name AS customer_name FROM orders o
INNER JOIN customers c ON c.customer_id = o.customer_id
WHERE shipped_date > required_date;

--38. 10248 nolu siparişte satılan ürünlerin adı, kategorisinin adı, adedi
SELECT od.order_id, od.quantity, p.product_name, c.category_name FROM products p
INNER JOIN order_details od ON od.product_id = p.product_id
INNER JOIN categories c ON c.category_id = p.category_id
WHERE od.order_id = 10248;

--39. 10248 nolu siparişin ürünlerinin adı , tedarikçi adı   
SELECT od.order_id, p.product_name, s.company_name AS supplier_name FROM products p
INNER JOIN order_details od ON od.product_id = p.product_id
INNER JOIN suppliers s ON s.supplier_id = p.supplier_id
WHERE od.order_id = 10248;

--40. 3 numaralı ID ye sahip çalışanın 1997 yılında sattığı ürünlerin adı ve adeti
SELECT p.product_name, SUM(od.quantity) FROM order_details od
INNER JOIN orders o ON o.order_id = od.order_id
INNER JOIN products p ON p.product_id = od.product_id
WHERE EXTRACT(YEAR FROM o.order_date) = 1997 AND o.employee_id=3
GROUP BY p.product_id;

--41. 1997 yılında bir defasinda en çok satış yapan çalışanımın ID,Ad soyad

--According to the quantity:
SELECT od.order_id, SUM(od.quantity) AS total_sales_at_one_time, CONCAT(e.first_name, ' ', e.last_name) AS employee_name, e.employee_id 
FROM orders o
INNER JOIN order_details od ON od.order_id = o.order_id
INNER JOIN employees e ON e.employee_id = o.employee_id
GROUP BY od.order_id, e.employee_id
ORDER BY total_sales_at_one_time DESC LIMIT 1;

--According to the revenue:
select e.employee_id,e.first_name,e.last_name,o.order_id,o.order_date,cast(sum(od.unit_price*(1-od.discount)*od.quantity) as real) as "Revenue" from orders o
join employees e on o.employee_id = e.employee_id
join order_details od on o.order_id = od.order_id
where extract(year from o.order_date)=1997
group by o.order_id,e.employee_id
order by "Revenue" desc
limit 1;

--42. 1997 yılında en çok satış yapan çalışanımın ID,Ad soyad ****
--Quantity'e göre
select e.employee_id,e.first_name,e.last_name, sum(od.quantity) as "toplam" from orders o
inner join employees e on e.employee_id = o.employee_id
inner join order_details od on o.order_id = od.order_id
where extract(year From o.order_date)=1997
group by e.employee_id
order by toplam desc limit 1

---Price'a göre

select e.employee_id,e.first_name,e.last_name,cast(sum(od.unit_price*(1-od.discount)*od.quantity) as real) as "TotalSale" from order_details od
join orders o on od.order_id = o.order_id
join employees e on o.employee_id = e.employee_id
where extract(year from o.order_date)=1997
group by e.employee_id
order by "TotalSale" desc
limit 1;


--43. En pahalı ürünümün adı,fiyatı ve kategorisin adı nedir?

select  p.product_name,p.unit_price,c.category_name from products p
inner join categories c on p.category_id = c.category_id
ORDER BY unit_price DESC
Limit 1;

--44. Siparişi alan personelin adı,soyadı, sipariş tarihi, sipariş ID. Sıralama sipariş tarihine göre

select e.first_name,e.last_name,o.order_id,o.order_date from orders o
inner join employees e on o.employee_id = e.employee_id
order by order_date;

--45. SON 5 siparişimin ortalama fiyatı ve orderid nedir?
select  o.order_id,o.order_date,avg(od.unit_price*od.quantity)as "ortalamaFiyat" from order_details od
inner join orders o on od.order_id = o.order_id
group by o.order_id
order by o.order_id desc limit 5


--46. Ocak ayında satılan ürünlerimin adı ve kategorisinin adı ve toplam satış miktarı nedir?

select p.product_name,c.category_name,sum(od.quantity) as "Total Sale" from products p
join order_details od on p.product_id = od.product_id
join orders o on od.order_id = o.order_id
join categories c on p.category_id = c.category_id
where extract(month from o.order_date)=1
group by p.product_id,c.category_id; 

 --47. Ortalama satış miktarımın üzerindeki satışlarım nelerdir?
--quantitiy baz alınmıstır.

SELECT od.order_id, SUM(od.quantity) AS total_sales_quantity FROM order_details od
GROUP BY od.order_id
HAVING SUM(od.quantity) > (SELECT AVG(total_sales_quantity) FROM (SELECT SUM(quantity) AS total_sales_quantity FROM order_details GROUP BY order_id) AS subquery)
order by total_sales_quantity asc;

--With kullanılarak yapılmıştır.

 WITH orders_grouped as (
    select od.order_id,sum(od.unit_price*(1-od.discount)*od.quantity) as order_total from order_details od
    group by od.order_id
)
select od.order_id,sum(od.unit_price*(1-od.discount)*od.quantity) as order_total from order_details od
group by od.order_id
having sum(od.unit_price*(1-od.discount)*od.quantity) > (select avg(og.order_total) from orders_grouped og)
order by order_total;

--unit price baz alınmıştır.
select od.order_id,sum(od.unit_price*(1-od.discount)*od.quantity) as order_total from order_details od
group by od.order_id
having sum(od.unit_price*(1-od.discount)*od.quantity) > (select avg(total_sale_per_order) from 
                                                         (select sum(od2.unit_price*(1-od2.discount)*od2.quantity) as total_sale_per_order from order_details od2
                                                          group by od2.order_id))
order by order_total;


--48. En çok satılan ürünümün(adet bazında) adı, kategorisinin adı ve tedarikçisinin adı

Select p.product_name,c.category_name,s.company_name,sum(od.quantity) as totalquantity from order_details as od
inner join products as p on od.product_id = p.product_id
inner join suppliers as s on p.supplier_id = s.supplier_id
inner join categories as c on p.category_id = c.category_id
group by p.product_id,c.category_id,s.supplier_id
order by totalquantity desc limit 1;

--49. Kaç ülkeden müşterim var
select count (distinct  country) from customers

--50. 3 numaralı ID ye sahip çalışan (employee) son Ocak ayından BUGÜNE toplamda ne kadarlık ürün sattı?
select e.employee_id,e.first_name,e.last_name,sum(od.unit_price*od.quantity) as toplamsatıs from order_details od
inner join orders o on o.order_id = od.order_id
inner join employees e on e.employee_id = o.employee_id
where order_date >'01/01/1998' and e.employee_id=3
group by e.employee_id


--51. 10248 nolu siparişte satılan ürünlerin adı, kategorisinin adı, adedi

select od.order_id, p.product_name,c.category_name,quantity from order_details as od
inner join products p on od.product_id = p.product_id
inner join categories as c on p.category_id = c.category_id
where od.order_id=10248


--52. 10248 nolu siparişin ürünlerinin adı , tedarikçi adı

select od.order_id,p.product_name, s.company_name from products p
inner join order_details od on p.product_id=od.product_id
inner join suppliers s on s.supplier_id=p.supplier_id
where od.order_id=10248


--53. 3 numaralı ID ye sahip çalışanın 1997 yılında sattığı ürünlerin adı ve adeti

select  p.product_name,sum(od.quantity) from order_details od
inner join orders o on o.order_id = od.order_id
inner join employees e on o.employee_id = e.employee_id
inner join products p on p.product_id = od.product_id
where extract(year From o.order_date)=1997 and e.employee_id=3
group by p.product_id

--54. 1997 yılında bir defasinda en çok satış yapan çalışanımın ID,Ad soyad
41.soru ile aynı

--55. 1997 yılında en çok satış yapan çalışanımın ID,Ad soyad ****
42.soruyla aynı

--56. En pahalı ürünümün adı,fiyatı ve kategorisin adı nedir?
43.soru ile aynı


--57. Siparişi alan personelin adı,soyadı, sipariş tarihi, sipariş ID. Sıralama sipariş tarihine göre
44.sour ile aynı

--58. SON 5 siparişimin ortalama fiyatı ve orderid nedir?
45.soru ile aynı

--59. Ocak ayında satılan ürünlerimin adı ve kategorisinin adı ve toplam satış miktarı nedir?
46.soru ile aynı

--60. Ortalama satış miktarımın üzerindeki satışlarım nelerdir?
47.soru ile aynı

--61. En çok satılan ürünümün(adet bazında) adı, kategorisinin adı ve tedarikçisinin adı
48.soru ile aynı

--62. Kaç ülkeden müşterim var
49.soru ile aynı

--63. Hangi ülkeden kaç müşterimiz var

SELECT 
    country, COUNT(*) AS CustomerCount
FROM 
    customers
GROUP BY 
    country;

--64. 3 numaralı ID ye sahip çalışan (employee) son Ocak ayından BUGÜNE toplamda ne kadarlık ürün sattı?
50.soru ile aynı

--65. 10 numaralı ID ye sahip ürünümden son 3 ayda ne kadarlık ciro sağladım?

ELECT 
    SUM(od.unit_price * od.quantity) AS TotalRevenue
FROM 
    orders o
JOIN 
    order_details od ON o.order_id = od.order_id
WHERE 
    od.product_id = 10
    AND o.order_date >= (SELECT MAX(order_date) - INTERVAL '3 months' FROM orders);
	
--66. Hangi çalışan şimdiye kadar toplam kaç sipariş almış..?

SELECT 
    CONCAT(e.first_name, ' ', e.last_name) AS full_name,
    COUNT(*) AS TotalOrders
FROM 
    orders o
JOIN 
    employees e ON o.employee_id = e.employee_id
GROUP BY 
    full_name;
---------------------------
SELECT 
    employee_id, COUNT(*) AS TotalOrders
FROM 
    orders
GROUP BY 
    employee_id;
		
--67. 91 müşterim var. Sadece 89’u sipariş vermiş. Sipariş vermeyen 2 kişiyi bulun

SELECT 
    c.customer_id, c.company_name, c.contact_name
FROM 
    customers c
LEFT JOIN 
    orders o ON c.customer_id = o.customer_id
WHERE 
    o.order_id IS NULL;
	
	
--68. Brazil’de bulunan müşterilerin Şirket Adı, TemsilciAdi, Adres, Şehir, Ülke bilgileri

SELECT 
    company_name, contact_name, address, city, country
FROM 
    customers
WHERE 
    country = 'Brazil';
	
	
--69. Brezilya’da olmayan müşteriler

SELECT 
    *
FROM 
    customers
WHERE 
    country != 'Brazil';
	
	
--70. Ülkesi (Country) YA Spain, Ya France, Ya da Germany olan müşteriler

SELECT * FROM customers 
WHERE country IN ('Spain', 'France', 'Germany');

--71. Faks numarasını bilmediğim müşteriler

SELECT * FROM customers
WHERE fax IS NULL;


--72. Londra’da ya da Paris’de bulunan müşterilerim

SELECT * FROM customers 
WHERE city IN ('London', 'Paris');

--73. Hem Mexico D.F’da ikamet eden HEM DE ContactTitle bilgisi ‘owner’ olan müşteriler

SELECT * FROM customers
WHERE city = 'México D.F.' AND contact_title = 'Owner';

--74. C ile başlayan ürünlerimin isimleri ve fiyatları

SELECT product_name, unit_price FROM products
WHERE product_name LIKE 'C%';

--75. Adı (FirstName) ‘A’ harfiyle başlayan çalışanların (Employees); Ad, Soyad ve Doğum Tarihleri

SELECT first_name, last_name, birth_date FROM employees
WHERE first_name LIKE 'A%';

-- 76. İsminde ‘RESTAURANT’ geçen müşterilerimin şirket adları
SELECT company_name FROM customers
WHERE company_name ILIKE '%RESTAURANT%';

-- 77. 50$ ile 100$ arasında bulunan tüm ürünlerin adları ve fiyatları
SELECT product_name, unit_price FROM products
WHERE unit_price BETWEEN 50 AND 100

-- 78. 1 temmuz 1996 ile 31 Aralık 1996 tarihleri arasındaki siparişlerin (Orders), SiparişID (OrderID) ve SiparişTarihi (OrderDate) bilgileri
SELECT order_id, order_date FROM orders
WHERE order_date BETWEEN '1996-07-01' AND '1996-12-31'

-- 79. Ülkesi (Country) YA Spain, Ya France, Ya da Germany olan müşteriler
-- Aynı soru, farklı çözüm
SELECT * FROM customers 
WHERE country = 'Spain' OR country = 'France' OR country = 'Germany';

-- 80. Faks numarasını bilmediğim müşteriler
SELECT * FROM customers
WHERE fax IS NULL;

-- 81. Müşterilerimi ülkeye göre sıralıyorum:
SELECT * FROM customers 
ORDER BY country;

-- 82. Ürünlerimi en pahalıdan en ucuza doğru sıralama, sonuç olarak ürün adı ve fiyatını istiyoruz
SELECT product_name, unit_price FROM products
ORDER BY unit_price DESC;

-- 83. Ürünlerimi en pahalıdan en ucuza doğru sıralasın, ama stoklarını küçükten-büyüğe doğru göstersin sonuç olarak ürün adı ve fiyatını istiyoruz
SELECT product_name, unit_price FROM products
ORDER BY unit_price DESC;

SELECT product_name, unit_price FROM products
ORDER BY units_in_stock ASC;

-- 84. 1 Numaralı kategoride kaç ürün vardır..?
SELECT COUNT(*) FROM products
WHERE category_id = 1;

--85. Kaç farklı ülkeye ihracat yapıyorum..?
--select * from orders;
select count(distinct ship_country) as "Ihracat Yapilan Ulke Sayisi" from orders;

--86. a.Bu ülkeler hangileri..?
select distinct ship_country as "Ihracat Yapilan Ulkeler" from orders;

--87. En Pahalı 5 ürün
select product_name,unit_price from products
order by unit_price desc
limit 5;

--88. ALFKI CustomerID’sine sahip müşterimin sipariş sayısı..?
select count(*) from orders where customer_id='ALFKI';

--89. Ürünlerimin toplam maliyeti
select cast(sum(unit_price*units_in_stock) as real) as "Toplam Maliyet" from products;

--90. Şirketim, şimdiye kadar ne kadar ciro yapmış..?
select cast(sum(unit_price*quantity) as real) as "Toplam Ciro" from order_details;

--91. Ortalama Ürün Fiyatım
select cast(avg(unit_price) as real) from products;

--92. En Pahalı Ürünün Adı
select product_name from products
order by unit_price desc
limit 1;

--93. En az kazandıran sipariş
select o.* as "Siparis Id",cast(sum(od.unit_price*(1-od.discount)*od.quantity) as real) as "Siparis Tutari" from orders o
join order_details od on od.order_id = o.order_id
group by o.order_id
order by "Siparis Tutari"
limit 1;

--94. Müşterilerimin içinde en uzun isimli müşteri
select * from customers
order by length(contact_name) desc
limit 1;

--95. Çalışanlarımın Ad, Soyad ve Yaşları
--select * from employees;
select first_name,last_name,(extract(year from current_date)) - (extract(year from birth_date)) as "Employee Age" from employees;

--96. Hangi üründen toplam kaç adet alınmış..?
select p.product_id,p.product_name,sum(od.quantity) as "Satis Adedi" from products p
join order_details od on od.product_id = p.product_id
group by p.product_id;

--97. Hangi siparişte toplam ne kadar kazanmışım..?
select o.order_id,cast(sum(od.unit_price*(1-od.discount)*od.quantity) as real) as "Siparis Tutari" from orders o
join order_details od on od.order_id = o.order_id
group by o.order_id;

--98. Hangi kategoride toplam kaç adet ürün bulunuyor..?
select c.category_id,c.category_name,count(p) as "Urun Sayisi" from categories c
join products p on p.category_id = c.category_id
group by c.category_id;

--99. 1000 Adetten fazla satılan ürünler?
select p.product_id,p.product_name,sum(od.quantity) as "Satis Adedi" from products p
join order_details od on od.product_id = p.product_id
group by p.product_id
having sum(od.quantity)>1000;

--100. Hangi Müşterilerim hiç sipariş vermemiş..?
select c.* from customers c
left join orders o on c.customer_id = o.customer_id
where o.customer_id is null;