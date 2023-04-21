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
3. Inline `code` has `back-ticks around` it.



# API Documentation
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
- `GET /api/actors` - Get a list of all actors in the database.
- `GET /api/actors/{actorId}` - Get the details of a specific actor.

### Category
- `GET /api/categories` - Get a list of all categories in the database.
- `GET /api/categories/{categoryId}` - Get the details of a specific category.
### Film
- `GET /api/films` - Get a list of all films in the database.
- `GET /api/films/{filmId}` - Get the details of a specific film.
- `GET /api/films/{filmId}/rentals` - Get the rental history for a specific film.


### City
- `GET /api/cities` - Get a list of all cities in the database.
- `GET /api/cities/{cityId}` - Get the details of a specific city.

### Country
- `GET /api/countries` - Get a list of all countries in the database.
- `GET /api/countries/{countryId}` - Get the details of a specific country.

### Inventory
- `GET /api/inventories` - Get a list of all inventories in the database.
- `GET /api/inventories/{inventoryId}` - Get the details of a specific inventory.

### Laguage
- `GET /api/languagse` - Get a list of all languages in the database.
- `GET /api/languages/{languageId}` - Get the details of a specific language.

### Payment
- `GET /api/payments` - Get a list of all payments in the database.
- `GET /api/payments/{paymentId}` - Get the details of a specific payment.

### Rental
- `GET /api/rentals` - Get a list of all rentals in the database.
- `GET /api/rentals/{rentalId}` - Get the details of a specific rental.

### Staff
- `GET /api/staffs` - Get a list of all staffs in the database.
- `GET /api/staffs/{staffId}` - Get the details of a specific staffs.

### Store
- `GET /api/stores` - Get a list of all stores in the database.
- `GET /api/stores/{storeId}` - Get the details of a specific stores.


