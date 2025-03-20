## resource blocks to define components of the infrastructure wanted, in this case: 
# Create a resource Block for running a docker container for nginx
# ngnix docker image
resource "docker_image" "nginx" {
 name        = var.ngnix_version_dev
 keep_locally = false
}
# ngnix configuration 
resource "docker_container" "nginx" {
 image = docker_image.nginx.latest
 name  = var.ngnix_name_dev
 ports {
   internal = 80
   external = 80
 }
   volumes {
    host_path      = "/hello-world-dev.html"
    container_path = "/usr/share/nginx/html/index.html"
  }
}
