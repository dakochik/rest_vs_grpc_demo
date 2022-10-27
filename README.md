# REST vs gRPC demo application

## REST API

### Owner
Port: 8081  
```
GET /name

GET /name/pet
```

### Pet
Port: 8082  
```
GET /name

GET /name/owner
```

### API Gateway
Port: 8085  
```
GET /pet/** -> pet microservice

GET /owner/** -> owner microservice
```

### Service registry & discovery
Port: 8761

## gRPC API

###**TODO**