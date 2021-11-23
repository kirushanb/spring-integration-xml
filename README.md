# spring-integration

## Local Setup

- In a suitable code editor clone the repo
  ```sh 
  git clone https://github.com/Kirushan-Balakrishnan/spring-integration.git 
  ```

- Switch to the cloned repo  
  ```sh 
  cd spring-integration
  ```

## Run the application locally:

```sh 
mvn spring-boot:run 
```

## Test the application :

- To test the integration flow:
  - Authenticated and Active User:
    POST API call with payload
    {
    "name":"Lewis",
    "password":"lewis"
    }
      ```sh 
      http://localhost:8080/integrate
      ```
   - Unauthorized or Inactive User:
    POST API call with payload
    {
    "name":"Max",
    "password":"max"
    }
      ```sh 
      http://localhost:8080/integrate
      ```
