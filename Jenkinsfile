def terraform_plan(todo, rolearn) {
    withAWS(region: 'eu-west-1', role: rolearn) {
            if (todo == "Apply") {
                    sh "terraform plan -no-color"
            }
            else {
                sh "terraform plan -destroy -no-color"
            }
    }
}

def terraform_apply(todo, rolearn) {

    withAWS(region: 'eu-west-1', role: rolearn) {
            if (todo == "Apply") {
                    sh "terraform apply"
            }
            else {
                sh "terraform destroy"
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

        stage("Terraform Plan"){
            steps{
                    script {
                        terraoform_plan(todo, 'arn:aws:iam::679540287007:role/JenkinsDevelopmentRole')
                    }
                }
            }
        stage("Terraform Apply/Destroy") {
            steps {
                script {
                        
                        env.applyplan = input message: 'Apply Plan ? ', ok: 'Release!',
                                                parameters: [
                                                    choice(name: 
                                                    'apply', 
                                                        choices: 'Yes\nNo', 
                                                        description: 'Do you want to apply Terraform Plan ?')
                                                    ]
                        echo "${env.applyplan}"       
                        if (env.applyplan == "Yes") {
                            terraform_apply(todo, 'arn:aws:iam::679540287007:role/JenkinsDevelopmentRole') 
                        }
                        else {
                            echo "Terraform changes not applied. "
                        }
            }
        }

        }
    }
}

