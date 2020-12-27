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
    **Content:** `{ id : 12, name : "Michael Bloom" }`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "User doesn't exist" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

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
