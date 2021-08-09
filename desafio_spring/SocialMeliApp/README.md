# Social-Meli App 

## 🛢️ Database

En el archivo [***users.json***](https://github.com/devMaRP/meli_bootcamp_w11/tree/salazar_iba%C3%B1ez/desafio_spring/SocialMeliApp/src/main/resources/users.json) 
y [***post.json***](https://github.com/devMaRP/meli_bootcamp_w11/tree/salazar_iba%C3%B1ez/desafio_spring/SocialMeliApp/src/main/resources/post.json) 
se encontrara la información de algunos usuarios y post con productos 
que seran cargados al momento de iniciar la app, esto con el fin de 
agilizar el proceso de test y tener alguna persistencia de los datos.

## 📑 Documentacion

### Documentacion para Frontend

En el siguiente link: [***Documentacion***](https://documenter.getpostman.com/view/16046826/TzsikPwV) 
se podra ver de manera detallada y estetica, el uso de los diferentes 
**EndPoints** desde distintos lenguajes, se podra detallar como se hacen 
las llamadas desde diferentes lenguajes.


### Colecccion de Postman
Se adjunta la coleccion generada de **Postman**: [***Coleccion.json***](https://github.com/devMaRP/meli_bootcamp_w11/tree/salazar_iba%C3%B1ez/desafio_spring/SocialMeliApp/src/main/resources/Social_Meli_App.postman_collection.json) 
para que puedan hacer las pruebas de la **API** ajustandose a los 
casos de uso usados al momento del desarrollo.


## 💻 Funcionalidades extras añadidas (Endpoints)

### US 0013

#### Obtener un listado de de todos los productos en promocion que pertenecen a una categoria especifica y mostrar su precio neto despues de aplicar el descuento

### Sing:

| Method            | SING        |
|-------------------|-------------|
| GET               | /products/category/{category}/list    |
| RESPONSE        | 
    [
        {
            "category": 150,
            "detail": {
                "productId": 20,
                "productName": "Dishes Gamer",
                "type": "Gamer",
                "brand": "Abba",
                "color": "Blue",
                "notes": "Dragon Edition"
            },
            "price": 1000.0,
            "discount": 0.25,
            "netPrice": 750.0
        },
        {
            "category": 150,
            "detail": {
                "productId": 30,
                "productName": "Dishes Gamer",
                "type": "Gamer",
                "brand": "Abba",
                "color": "Blue",
                "notes": "Dragon Edition"
            },
            "price": 750.0,
            "discount": 0.3,
            "netPrice": 525.0
        }
    ]
|

### Filtro/Parámetros
| Parámetros   | Tipo    | Descripción       |
|--------------|---------|-------------------|
| category     |   int      | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58
| detail     |   product      | Hace referencia al producto y contiene todos los detalles especificos del producto
| price     |   double      | Precio del producto
| discount     |   double      | Hace referencia al monto des descuento para dicho producto en promocion
| netPrice     |   double      | Precio neto a pagar por el producto despues de aplicar el descuento



