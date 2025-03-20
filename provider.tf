## terraform block specifying the source for required Docker provider and its version.
terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 2.21.0"
}
}
# #supports state locking remotly. When locking support is enabled it will use LOCK and UNLOCK requests providing the lock info in the body
#   backend "http" {
#   }
}
## A provider is a plugin that Terraform uses to create and manage your resources.
provider "docker" {}
