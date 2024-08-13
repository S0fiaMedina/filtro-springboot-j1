# Filtro de SpringBoot



### Autoría

**Nombre:** Sofia Marcela Medina Díaz



### Tabla seleccionada

=======> MEDICINE



### EndPoints



#### POST

`http://localhost:8080/medicines`

- **Json de prueba**

  ```json
  {
      "proceedings": "Inyeccion",
      "nameMedicine": "penicilina",
      "healthRegister": "1234",
      "description": "xxxxxxxxx",
      "descriptionShort": "xxxxx",
      "nameRol": "sss",
      "modeAdministrationId": 1,
      "activePrincipleId": 1,
      "unitMeasurementId": 1,
      "laboratoryId": 1,
      "pricesFarmacy":[
          {
              "idFarmacy": 1,
              "price": 500
          }
      ]
  }
  ```

  

#### GET

- **Get All: **
  - `http://localhost:8080/medicines`
- **Get By Id**
  - `http://localhost:8080/medicines/{id}`

#### PUT

`http://localhost:8080/medicines/{id}`

- **Json de prueba**

  ```json
  {
  	"id": 1,
      "proceedings": "Inyeccion",
      "nameMedicine": "PENICILINA",
      "healthRegister": "3333",
      "description": "Antibiotico suministrado para combatir enfermedades",
      "descriptionShort": "Antibiotico",
      "nameRol": "sss",
      "modeAdministrationId": 1,
      "activePrincipleId": 1,
      "unitMeasurementId": 1,
      "laboratoryId": 1,
      "pricesFarmacy":[
          {
  			"farmacyMedicineId": 1,
              "idFarmacy": 1,
              "price": 500
          }
      ]
  }
  ```

  

#### DELETE

`http://localhost:8080/medicines/{id}`