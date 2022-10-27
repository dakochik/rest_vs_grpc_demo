rootProject.name = "rest-vs-grpc-demo"

include("rest:owner-microservice")
findProject(":rest:owner-microservice")?.name = "owner-microservice"
include("rest:pet-microservice")
findProject(":rest:pet-microservice")?.name = "pet-microservice"
include("eureka-server-microservice")
include("shared:eureka-server-microservice")
findProject(":shared:eureka-server-microservice")?.name = "eureka-server-microservice"
include("rest:gateway")
findProject(":rest:gateway")?.name = "gateway"
include("grpc:contract")
findProject(":grpc:contract")?.name = "contract"
include("grpc:owner-microservice")
findProject(":grpc:owner-microservice")?.name = "owner-microservice"
include("grpc:pet-microservice")
findProject(":grpc:pet-microservice")?.name = "pet-microservice"
include("grpc:gateway")
findProject(":grpc:gateway")?.name = "gateway"
