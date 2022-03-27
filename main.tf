resource "aws_s3_bucket" "mybucket" {
  bucket = "679540287007-informa-london-unique1001"
  tags = {
    Name        = "My bucket"
    Environment = "Dev"
  }
}

resource "aws_instance" "MyAWSResource" {

   ami             = "ami-0ec23856b3bad62d3"
   instance_type   = "t2.micro"
}

terraform {
  backend "s3" {
    bucket         = "679540287007-informa-london-unique"
    key            = "development/terraform.tfstate"
    region         = "eu-west-1"
    dynamodb_table = "dev_terraform_state"
  }
}