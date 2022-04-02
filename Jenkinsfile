def apply_destroy(todo, rolearn) {
    withAWS(region: 'eu-west-1', role: rolearn) {
            if (todo == "Apply") {
                    sh "terraform plan -no-color"
            }
            else {
                sh "terraform plan -destroy -no-color"
            }
    }
}


pipeline {

    agent{
        label "west"
    }
     parameters {
    
         choice(
                name: 'todo', choices: 'Apply\nDestroy', 
                description: 'Do you want to Apply/Destroy Terraform Plan ?')
    }

    stages{
        
    stage("Terraform Init") {
        steps{
            withAWS(region: 'eu-west-1', role: 'arn:aws:iam::679540287007:role/JenkinsDevelopmentRole') {
                 sh "terraform init -no-color"
            }
        }
    }

    }

     
   }
