## resource blocks to define components of the infrastructure wanted, in this case: 
# Create a resource Block for running a docker container for nginx
# ngnix docker image
resource "docker_image" "nginx" {
 name         = "nginx:latest"
 keep_locally = false
}
# ngnix configuration 
resource "docker_container" "nginx" {
 image = "nginx:latest"
 name  = var.ngnix_name_dev
 ports {
   internal = 80
   external = 8080
 }
   volumes {
    host_path      = "/hello-world-dev.html"
    container_path = "/usr/share/nginx/html/index.html"
 #   container_path= "/var/run/docker.sock:/var/run/docker.sock"
  }
}
