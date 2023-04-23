# Sakila API REST with JAX-RS
This is a sample Sakila API REST project using JAX-RS. It provides a set of endpoints to manage the Sakila sample database, which includes information about movies, actors, and rental records.
# Getting Started
To run this project, you will need:
1. Clone the project from GitHub:
  [Sakila_Rest_API](https://github.com/Dina-Mishahed/Sakila_Rest_API)
```
https://github.com/Dina-Mishahed/Sakila_Rest_API
```
2. Update the db.properties file with your MySQL database connection details.



# API Documentation

[Postman RESTful API](https://documenter.getpostman.com/view/15142862/2s93Y5PKhB)

# Technologies Used 
* Java 17
* Maven
* Tomcat 10
* JAX-RS (Jersey)
* Java Persistence API (Hibernate)
* MapStruct
* PostMan
* MySql
* JSON-B
* JAX-B
# API Endpoints

The following API endpoints are available:

### Actor
- `GET /restapi/actors` - Get a list of all actors in the database.
- `GET /restapi/actors/{actorId}` - Get the details of a specific actor.
- `DELETE /restapi/actors` -  delete the actor.
- `POST /restapi/actors/{actorId}` - insert the new actor.
- `PUT /restapi/actors/{actorId}` - update the details of a specific actor.
- `GET /restapi/actors/getFilms/{actorId}` - Get the films of a specific actor.

### Category
- `GET /restapi/categories` - Get a list of all categories in the database.
- `GET /restapi/categories/{categoryId}` - Get the details of a specific category.
- `GET /restapi/categories/getFilmsByCategoryNo/{categoryId}` - Get the count of films in a specific category.
- `GET /restapi/categories/searchCategoryByName/{categoryName}` - Search category by name.
- `GET /restapi/categories/getFilms/{categoryId}` - Get films of the a specific category.


### Film
- `GET /restapi/films` - Get a list of all films in the database.
- `GET /restapi/films/{filmId}` - Get the details of a specific film.
- `GET /restapi/films/{filmId}/rentals` - Get the rental history for a specific film.
- `DELETE /restapi/films` -  delete the film.
- `POST /restapi/films/{filmId}` - insert the new film.
- `PUT /restapi/films/{filmId}` - update the details of a specific film.

### City
- `GET /restapi/cities` - Get a list of all cities in the database.
- `GET /restapi/cities/{cityId}` - Get the details of a specific city.

### Country
- `GET /restapi/countries` - Get a list of all countries in the database.
- `GET /api/countries/{countryId}` - Get the details of a specific country.
- `GET /api/countries/cities/{countryId}` - Get the cities in a specific country.

### Inventory
- `GET /restapi/inventories` - Get a list of all inventories in the database.
- `GET /restapi/inventories/{inventoryId}` - Get the details of a specific inventory.


### Rental
- `GET /restapi/rentals` - Get a list of all rentals in the database.
- `GET /restapi/rentals/{rentalId}` - Get the details of a specific rental.
- `GET /restapi/rentals/payments/{rentalId}` - Get a list of all payments of a specific rental.

### Staff
- `GET /restapi/staffs` - Get a list of all staffs in the database.
- `GET /restapi/staffs/{staffId}` - Get the details of a specific staffs.
- `PUT /restapi/staffs/` - update staff details.
- `GET /restapi/staffs/rentals/{staffId}` - Get a list of all rentals of a specific staff.

### Store
- `GET /restapi/stores/{storeId}` - Get the details of a specific stores.
- `GET /restapi/stores` - Get a list of all stores in the database.
- `POST /restapi/stores/add` -create new store.
- `GET /restapi/stores/inventories/{storeId}` - Get a list of all inventories of a specific store.
- `GET /restapi/stores/customers/{storeId}` - Get a list of all customers of a specific store.
- `GET /restapi/stores/staffs/{storeId}` -  Get a list of all staffs of a specific store.

### Laguage
- `GET /restapi/languagse` - Get a list of all languages in the database.
- `GET /restapi/languages/{languageId}` - Get the details of a specific language.

### Payment
- `GET /restapi/payments` - Get a list of all payments in the database.
- `GET /restapi/payments/{paymentId}` - Get the details of a specific payment.

