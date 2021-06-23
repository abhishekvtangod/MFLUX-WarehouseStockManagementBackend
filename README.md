Frontend:
https://github.com/prajwalsfs1721/Databse-Project-Frontend

# WarehouseStockManagementAPI

## API endpoints:


**Show Warehouses**
----
  Returns json data of all Warehouses.

* **URL**

  /WarehouseStocksManagementAPI/Warehouse

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
  [{
    "Wid" : 1682,
    "is_functional" : 1,
    "company":"NearoAI", 
    "address":"MSRIT Bangalore",
    "supervisor_id" : 11
  }]
  ``` 
* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    None


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
    **Content:** 
  ```json
	[{
	   "empid":72,
	   "emp_name":"abhi",
	   "emp_shift":"M",
	   "emp_sal": 9000,
	   "wid": 5
	}]

  ``` 
* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    None










**Show Vehicles**
----
  Returns json data of all Vehicles.

* **URL**

  /WarehouseStocksManagementAPI/Vehicle

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
	[{
	   "in_wh":5,
	   "reg_num":"abhi",
	   "model":"abhi",
	   "type": "abhi",
	   "last_maintainence": "2020-05-09"
	}]
  ``` 
* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    None








**Show Logistics**
----
  Returns json data of all Logistics.

* **URL**

  /WarehouseStocksManagementAPI/Logistics

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
	[{
	   "logistics_id":1,
	   "start_addr":"abhi",
	   "end_addr":"abhi",
	   "dispatch_datetime": "2020-12-16 18:00:01",
	   "receive_datetime": "2020-12-16 18:00:01",
	   "vehicle": "vinod"
	}]

  ``` 
* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
	None










**Show Consumers**
----
  Returns json data of all Consumers.

* **URL**

  /WarehouseStocksManagementAPI/Consumer

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
  [{
   "consumer_id":1,
   "consumer_name":"abhi",
   "phone":"54645",
   "email": "abhi"
  }]

  ``` 
* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    None










**Show Suppliers**
----
  Returns json data of all Suppliers.

* **URL**

  /WarehouseStocksManagementAPI/Supplier

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
	[{
	   "supplier_id":1,
	   "supplier_name":"abhi",
	   "phone":"54645",
	   "email": "abhi"
	}]
  ``` 
  
* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
	None








**Show Goods**
----
  Returns json data of all Goods.

* **URL**

  /WarehouseStocksManagementAPI/Goods

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
	[{
	 "goods_id": 3,
	 "is_sensitive": 1,
	 "storage": 14,
	 "weight": 200,
	 "cost": 2990,
	 "arrival": 5,
	 "supplier":6,
	 "departure": 122,
	 "consumer": 0,
	 "goods_name": "abhi",
	 "category": "Other",
	 "wid": 5,
	 "bin":1
	}]
 

  ``` 
* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    None



**Show Category**
----
  Returns json data of all Goods.

* **URL**

  /WarehouseStocksManagementAPI/Category

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
	[{
	 "category_name": "abhi"
	}]

  ``` 
* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    None


--------------------


**Insert Warehouses**
----
  Inserts data of a particular new Warehouse into Warehouse table in the database.

* **URL**

  /WarehouseStocksManagementAPI/Warehouse

* **Method:**

  `POST`
  
*  **URL Params**

    None

* **Data Params**

  ```json
  {
    "Wid" : 1682,
    "is_functional" : 1,
    "company":"NearoAI", 
    "address":"MSRIT Bangalore",
    "supervisor_id" : 11
  }
  ``` 

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

  ```json
	{ 
		"Result": "inserted successfully" 
	}

  ``` 

* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    	
  ```json
	{ 
		"Result": "Insertion failed" 
	}

  ``` 




**Insert Employees**
----
  Inserts data of a particular new Employee into Employee table in the database.

* **URL**

  /WarehouseStocksManagementAPI/Employee

* **Method:**

  `POST`
  
*  **URL Params**

    None

* **Data Params**

  ```json
  {
    "Wid" : 1682,
    "is_functional" : 1,
    "company":"NearoAI", 
    "address":"MSRIT Bangalore",
    "supervisor_id" : 11
  }
  ``` 

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

  ```json
	{ 
		"Result": "inserted successfully" 
	}

  ``` 



* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    	
  ```json
	{ 
		"Result": "Insertion failed" 
	}

  ``` 










**Insert Vehicles**
----
  Inserts data of a particular new Vehicle into Vehicles table in the database.

* **URL**

  /WarehouseStocksManagementAPI/Vehicle

* **Method:**

  `POST`
  
*  **URL Params**

    None

* **Data Params**

  ```json
  {
    "Wid" : 1682,
    "is_functional" : 1,
    "company":"NearoAI", 
    "address":"MSRIT Bangalore",
    "supervisor_id" : 11
  }
  ``` 

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

  ```json
	{ 
		"Result": "inserted successfully" 
	}

  ``` 


* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
		
  ```json
	{ 
		"Result": "Insertion failed" 
	}

  ``` 










**Insert Logistics**
----
  Inserts data of a particular new Logistics into Logistics table in the database.


* **URL**

  /WarehouseStocksManagementAPI/Logistics

* **Method:**

  `POST`
  
*  **URL Params**

    None

* **Data Params**

  ```json
  {
    "Wid" : 1682,
    "is_functional" : 1,
    "company":"NearoAI", 
    "address":"MSRIT Bangalore",
    "supervisor_id" : 11
  }
  ``` 


* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

  ```json
	{ 
		"Result": "inserted successfully" 
	}

  ``` 


* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    	
  ```json
	{ 
		"Result": "Insertion failed" 
	}

  ``` 











**Insert Consumers**
----
  Inserts data of a particular new Consumer into Consumer table in the database.

* **URL**

  /WarehouseStocksManagementAPI/Consumer

* **Method:**

  `POST`
  
*  **URL Params**

    None

* **Data Params**

  ```json
  {
    "Wid" : 1682,
    "is_functional" : 1,
    "company":"NearoAI", 
    "address":"MSRIT Bangalore",
    "supervisor_id" : 11
  }
  ``` 

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

  ```json
	{ 
		"Result": "inserted successfully" 
	}

  ``` 


* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    	
  ```json
	{ 
		"Result": "Insertion failed" 
	}

  ``` 












**Insert Suppliers**
----
  Inserts data of a particular new Supplier into Supplier table in the database.

* **URL**

  /WarehouseStocksManagementAPI/Supplier

* **Method:**

  `POST`
  
*  **URL Params**

    None

* **Data Params**

  ```json
  {
    "Wid" : 1682,
    "is_functional" : 1,
    "company":"NearoAI", 
    "address":"MSRIT Bangalore",
    "supervisor_id" : 11
  }
  ``` 

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

  ```json
	{ 
		"Result": "inserted successfully" 
	}

  ``` 


* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    	
  ```json
	{ 
		"Result": "Insertion failed" 
	}

  ``` 










**Insert Goods**
----
  Inserts data of a particular new Goods into Goods table in the database.

* **URL**

  /WarehouseStocksManagementAPI/Goods

* **Method:**

  `POST`
  
*  **URL Params**

    None

* **Data Params**

  ```json
  {
    "Wid" : 1682,
    "is_functional" : 1,
    "company":"NearoAI", 
    "address":"MSRIT Bangalore",
    "supervisor_id" : 11
  }
  ``` 

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

  ```json
	{ 
		"Result": "inserted successfully" 
	}

  ``` 


* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
		
  ```json
	{ 
		"Result": "Insertion failed" 
	}

  ``` 





**Insert Category**
----
  Inserts data of a particular new Category into Category table in the database.


* **URL**

  /WarehouseStocksManagementAPI/Category

* **Method:**

  `POST`
  
*  **URL Params**

    None

* **Data Params**

```json
  {
    "Wid" : 1682,
    "is_functional" : 1,
    "company":"NearoAI", 
    "address":"MSRIT Bangalore",
    "supervisor_id" : 11
  }
  ``` 
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 

  ```json
	{ 
		"Result": "inserted successfully" 
	}

  ``` 


* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
	
  ```json
	{ 
		"Result": "Insertion failed" 
	}

  ``` 




--------------------


**Update Database Data**
----
  Updates data of a particular table in the database.

* **URL**

  /WarehouseStocksManagementAPI/Category

* **Method:**

  `POST`

* **Data Params**

  ```json

	{
	   "query": " UPDATE `DBMS_Project`.`Employee` SET `wid` = '5' WHERE (`empid` = '2')"
	}

  ```

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
  ```json
    
    { 
    	"Result": "Query Processed successfully" 
	}

  ``` 
* **Error Response:**

  * **Code:** 404  <br />
    **Content:** 
    ```json
    
    { 
    	"Result": "Query failed" 
	}

    ```
