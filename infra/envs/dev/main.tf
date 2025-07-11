module "vpc" {
  source     = "../../modules/vpc"
  name       = "growit-dev"
  cidr_block = "10.0.0.0/16"
}

module "subnet" {
  source = "../../modules/subnet"
  name   = "growit-dev"
  vpc_id = module.vpc.vpc_id
  public_subnet_cidrs = ["10.0.1.0/24", "10.0.2.0/24"]
  private_subnet_cidrs = ["10.0.3.0/24", "10.0.4.0/24"]
  availability_zones = ["ap-northeast-2a", "ap-northeast-2b"]
}

module "route" {
  source             = "../../modules/route"
  name               = "growit-dev"
  vpc_id             = module.vpc.vpc_id
  igw_id             = module.vpc.igw_id
  public_subnet_ids  = module.subnet.public_subnet_ids
  private_subnet_ids = module.subnet.private_subnet_ids
}

module "sg" {
  source = "../../modules/security-group"
  name   = "growit-dev"
  vpc_id = module.vpc.vpc_id
}

module "rds" {
  source             = "../../modules/rds"
  name               = "growit-dev"
  private_subnet_ids = module.subnet.private_subnet_ids
  db_sg_id           = module.sg.db_sg_id
  db_name            = "growitdb"
  db_username        = "postgres"
  db_password        = var.db_password
}


module "bastion" {
  source           = "../../modules/bastion"
  name             = "growit-dev"
  ami_id = "ami-0f3a440bbcff3d043" # ap-northeast-2 (서울)의 Amazon Linux 2 AMI
  public_subnet_id = module.subnet.public_subnet_ids[0]
  key_name         = var.bastion_key_name
  sg_id            = module.sg.bastion_sg_id
}

module "ecs" {
  source             = "../../modules/ecs"
  cluster_name       = "growit-dev-ecs"
  ami_id = "ami-0f3a440bbcff3d043" # Amazon Linux 2 ECS Optimized AMI (예시값, 실제로 확인 필요)
  key_name           = var.bastion_key_name
  instance_type      = "t3.micro"
  private_subnet_ids = module.subnet.private_subnet_ids
}

# ALB module
module "alb" {
  source            = "../../modules/alb"
  name              = "growit-dev"
  vpc_id            = module.vpc.vpc_id
  public_subnet_ids = module.subnet.public_subnet_ids
}

module "app_service" {
  source             = "../../modules/ecs-service/app"
  name               = "app"
  cluster_id         = module.ecs.cluster_id
  execution_role_arn = module.ecs.execution_role_arn
  image              = "nginxdemos/hello"
  container_port     = 80
  private_subnet_ids = module.subnet.private_subnet_ids
  sg_id              = module.sg.ecs_service_sg_id
  target_group_arn   = module.alb.target_group_arn
  alb_listener_arn   = module.alb.http_listener_arn
}
#
# module "gateway_service" {
#   source            = "../../modules/ecs-service/gateway"
#   cluster_name      = module.ecs.cluster_name
#   container_image   = "123456789012.dkr.ecr.ap-northeast-2.amazonaws.com/admin:latest"
#   container_port    = 8080
#   alb_listener_arn  = module.alb.http_listener_arn
#   target_group_path = "/admin"
# }


