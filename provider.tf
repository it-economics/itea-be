## terraform block specifying the source for required Docker provider and its version.
terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 2.21.0"
}
}
}
## A provider is a plugin that Terraform uses to create and manage your resources.
provider "docker" {}