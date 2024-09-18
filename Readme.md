# Catalog Service

This service helps to `add`, `update`, `search`, `delete` the desserts supplied by the bakery.

## Dependencies

```xml
<dependencies>
	   <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-hateoas</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
</dependencies>
```

## Endpoints

```
GET 		/api/desserts/categories 			Returns all categories of desserts
GET 		/api/desserts?page=0&size=10		Returns all deserts with 10 items per page
GET 		/api/desserts/{id}					Return the dessert with that id or 404
POST		/api/desserts`						Create a new dessert
PUT 		/api/desserts/{id}					Update the dessert with that id or 404
DELETE 		/api/desserts/{id}					Delete the dessert with that id or 404
```

## SQL

```sql
CREATE TABLE desserts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    price DECIMAL(5, 2) NOT NULL,
    image_thumbnail VARCHAR(255) NOT NULL,
    image_mobile VARCHAR(255) NOT NULL,
    image_tablet VARCHAR(255) NOT NULL,
    image_desktop VARCHAR(255) NOT NULL
);


INSERT INTO desserts (name, category, price, image_thumbnail, image_mobile, image_tablet, image_desktop)
VALUES
('Waffle with Berries', 'Waffle', 6.5, '/images/image-waffle-thumbnail.jpg', '/images/image-waffle-mobile.jpg', '/images/image-waffle-tablet.jpg', '/images/image-waffle-desktop.jpg'),
('Vanilla Bean Crème Brûlée', 'Crème Brûlée', 7.0, '/images/image-creme-brulee-thumbnail.jpg', '/images/image-creme-brulee-mobile.jpg', '/images/image-creme-brulee-tablet.jpg', '/images/image-creme-brulee-desktop.jpg'),
('Macaron Mix of Five', 'Macaron', 8.0, '/images/image-macaron-thumbnail.jpg', '/images/image-macaron-mobile.jpg', '/images/image-macaron-tablet.jpg', '/images/image-macaron-desktop.jpg'),
('Classic Tiramisu', 'Tiramisu', 5.5, '/images/image-tiramisu-thumbnail.jpg', '/images/image-tiramisu-mobile.jpg', '/images/image-tiramisu-tablet.jpg', '/images/image-tiramisu-desktop.jpg'),
('Pistachio Baklava', 'Baklava', 4.0, '/images/image-baklava-thumbnail.jpg', '/images/image-baklava-mobile.jpg', '/images/image-baklava-tablet.jpg', '/images/image-baklava-desktop.jpg'),
('Lemon Meringue Pie', 'Pie', 5.0, '/images/image-meringue-thumbnail.jpg', '/images/image-meringue-mobile.jpg', '/images/image-meringue-tablet.jpg', '/images/image-meringue-desktop.jpg'),
('Red Velvet Cake', 'Cake', 4.5, '/images/image-cake-thumbnail.jpg', '/images/image-cake-mobile.jpg', '/images/image-cake-tablet.jpg', '/images/image-cake-desktop.jpg'),
('Salted Caramel Brownie', 'Brownie', 4.5, '/images/image-brownie-thumbnail.jpg', '/images/image-brownie-mobile.jpg', '/images/image-brownie-tablet.jpg', '/images/image-brownie-desktop.jpg'),
('Vanilla Panna Cotta', 'Panna Cotta', 6.5, '/images/image-panna-cotta-thumbnail.jpg', '/images/image-panna-cotta-mobile.jpg', '/images/image-panna-cotta-tablet.jpg', '/images/image-panna-cotta-desktop.jpg');

```

## References

- https://howtodoinjava.com/spring/spring-hateoas-tutorial/