# WarehouseStockManagementBackend

## API endpoints:

**Show Warehouses**
----
  Returns json data of all Warehouses.

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
    **Content:** 
  ```json
  {
    "Wid" : 1682,
    "is_functional" : 1,
    "company":"NearoAI", 
    "address":"MSRIT Bangalore",
    "supervisor_id" : 11
  }
  ``` 
* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    ```json
    { 
    	"Result" : "Getting info from DB failed" 
    }
    ```
