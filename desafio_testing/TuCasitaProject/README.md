# TuCasita Tasaciones App 

## 🛢️ Database

En el archivo [***districts.json***](https://github.com/devMaRP/meli_bootcamp_w11/tree/salazar_iba%C3%B1ez/desafio_testing/TuCasitaProject/src/main/resources/districts.json)
se encontrara una lista de barrios populares de Argentina, esta lista 
sera cargada al momento de iniciar el programa, esto con el fin de 
tener un repositorio de barrios con el cual validar las entradas.

## 📑 Documentacion

### Documentacion endpoints para Frontend

En el siguiente link: [***Documentacion***](https://documenter.getpostman.com/view/16046826/Tzz8qw8u) 
se podra ver de manera detallada y estetica, el uso de los diferentes 
**EndPoints** utilizados en la aplicacion desde distintos lenguajes, se 
podra detallar como se harian las llamadas a los endpoints desde el front,
o sirve com guia para realizar las peticiones desde Postman.

### Colecccion de Postman
Se adjunta la coleccion generada de **Postman**: [***Coleccion.json***](https://github.com/devMaRP/meli_bootcamp_w11/tree/salazar_iba%C3%B1ez/desafio_testing/TuCasitaProject/src/main/resources/Tu_Casita_Test_Challenge.postman_collection.json) 
para que puedan hacer las pruebas de la **API** ajustandose a los 
casos de uso usados al momento del desarrollo.

## 💻 API Endpoints

### US 0001

#### Registrar una nueva propiedad (Se genera su **Unique ID**  de forma automatica con **UUID**)

### Sing:

| Method            | SING        |
|-------------------|-------------|
| POST               | /api/register/property    |
| PAYLOAD        | 
    {
        "prop_name": "Mansion PSG",
        "prop_land_width": 45.0,
        "prop_land_length": 55.5,
        "district": {
            "district_name": "Palermo",
            "district_built_price": 1800.0,
            "district_unbuilt_price": 600.0
        },
        "environments": [
            {
                "room_name": "Sala 1",
                "room_width": 15.0,
                "room_length": 30.0
            },
            {
                "room_name": "Pieza 1",
                "room_width": 10.0,
                "room_length": 18.0
            },
            {
                "room_name": "Pieza 2",
                "room_width": 17.0,
                "room_length": 17.0
            },
            {
                "room_name": "Patio",
                "room_width": 22.0,
                "room_length": 30.0
            }
        ]
    }

RESPONSE            | Status Code 201 (CREATED) / Status Code 400 (BAD REQUEST)|
|-------------------|-------------|

    {
    "id_property": 6748,
    "message": "Successful registration - with the id_property you can make the other queries"
    }

### Filtro/Parámetros
| Parámetros   | Tipo    | Descripción       |
|--------------|---------|-------------------|
| id_property     |   int      | Hace referencia al ID unico de la propiedad, se le genera un **id_property** si el request pasa las validaciones
| message    |   String      | Mensaje de registro de la propiedad exitoso con instrucciones

### US 0002

#### Obtener el total de metros cuadrados de la propiedad

### Sing:

| Method            | SING        |
|-------------------|-------------|
| GET               | /api/calculate/property/{id_property}/meters    |
| EJEMPLO               | /api/calculate/property/6748/meters    |
| RESPONSE        |
    {
        "property_name": "Mansion PSG",
        "total_square_meters": 2497.5
    }

### Filtro/Parámetros
| Parámetros   | Tipo    | Descripción       |
|--------------|---------|-------------------|
| property_name     |   String      | Hace referencia al nombre de la propiedad registrada
| total_square_meters     |   double      | Hace referencia al total de metros cuadrados de la propiedad

### US 0003

#### Obtener el valor total de la propiedad a partir de sus ambientes (construidos y no construidos)

### Sing:

| Method            | SING        |
|-------------------|-------------|
| GET               | /api/calculate/property/{id_property}/value    |
| EJEMPLO               | /api/calculate/property/6748/value   |
| RESPONSE        |
    {
        "property_name": "Mansion PSG",
        "district_name": "Palermo",
        "property_value": 3393300.0
    }

### Filtro/Parámetros
| Parámetros   | Tipo    | Descripción       |
|--------------|---------|-------------------|
| property_name     |   String      | Hace referencia al nombre de la propiedad registrada
| district_name     |   String      | Hace referencia al barrio al que pertenece la propiedad registrada
| property_value     |   double      | Hace referencia al precio total calculado para la propiedad

### US 0004

#### Obtener el ambiente mas grande de la propiedad

### Sing:

| Method            | SING        |
|-------------------|-------------|
| GET               | /api/calculate/property/{id_property}/biggestroom   |
| EJEMPLO               | /api/calculate/property/6748/biggestroom   |
| RESPONSE        |
    {
        "room_name": "Patio",
        "total_meters_room": 660.0
    }


### Filtro/Parámetros
| Parámetros   | Tipo    | Descripción       |
|--------------|---------|-------------------|
| room_name     |   String      | Hace referencia al nombre del ambiente mas grande
| total_meters_room    |   double      | Hace referencia al total de metros cuadrados del ambiente

### US 0005

#### Obtener todos los ambientes de la propiedad con el calculo de sus metros cuadrados

### Sing:

| Method            | SING        |
|-------------------|-------------|
| GET               | /api/calculate/property/{id_property}/rooms/meters   |
| EJEMPLO               | /api/calculate/property/6748/rooms/meters  |
| RESPONSE        |
    [
        {
            "room_name": "Sala 1",
            "total_meters_room": 450.0
        },
        {
            "room_name": "Pieza 1",
            "total_meters_room": 180.0
        },
        {
            "room_name": "Pieza 2",
            "total_meters_room": 289.0
        },
        {
            "room_name": "Patio",
            "total_meters_room": 660.0
        }
    ]


### Filtro/Parámetros
| Parámetros   | Tipo    | Descripción       |
|--------------|---------|-------------------|
| room_name     |   String      | Hace referencia al nombre del ambiente
| total_meters_room    |   double      | Hace referencia al total de metros cuadrados del ambiente

## 🎯 Resultados testing

Despues de realizar y probar el correcto funcionamiento para todos los test unitarios
y de integraciòn, teniendo en cuenta todas las posibilidades, casos de uso normales y casos bordes 
de la API segun el modelo utilizado, se obtuvieron los siguientes **coverage**:

### Coverage
- 100% Class (19/19)
- 100% Method (77/77)
- 97% Line (143/147)

## 🔔 Funcionalidades extras

Se planteó las siguientes funcionalidades o endpoints a implementar en un futuro

- Endpoint para obtener todas las propiedades con su precio, registradas a un barrio específico
- Endpoint para obtener la propiedad más grande asociada a un barrio
- Listar el histórico de propiedades registradas en la aplicación ordenadas alfabéticamente
- Listar propiedades estado 100% construido y propiedades que aun sus ambientes se encuentran 
  en construcción