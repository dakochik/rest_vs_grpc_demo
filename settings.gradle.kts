rootProject.name = "rest-vs-grpc-demo"

include("rest:owner-microservice")
findProject(":rest:owner-microservice")?.name = "owner-microservice"
include("rest:pet-microservice")
findProject(":rest:pet-microservice")?.name = "pet-microservice"
include("eureka-server-microservice")
include("rest:eureka-server-microservice")
findProject(":rest:eureka-server-microservice")?.name = "eureka-server-microservice"
include("rest:gateway")
findProject(":rest:gateway")?.name = "gateway"
