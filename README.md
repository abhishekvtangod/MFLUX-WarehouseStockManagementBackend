# WarehouseStockManagementBackend
### Database Systems Project Sem 5
## API endpoints:

**Show Employees**
----
  Returns json data of all Employees.

* **URL**

  /WarehouseStocksManagementAPI/Employee

* **Method:**

  `GET`
  
*  **URL Params**

    None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ Result : inserted successfully }`
 
* **Error Response:**

  * **Code:** 404  <br />
    **Content:** `{ Result : Insertion failed }`

* **Sample Call :**

  ```json
  {
    "Wid" : 1682,
    "is_functional" : 1,
    "company":"abhi", 
    "address":"abhi",
    "supervisor_id" : 11
  }
  ```
