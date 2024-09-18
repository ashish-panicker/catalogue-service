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

## References

- https://howtodoinjava.com/spring/spring-hateoas-tutorial/