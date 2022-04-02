def call(todo, rolearn, whatodo) {
    
    if (whatodo == "apply") {
        terraform_apply(todo,rolearn)
    }
    else if (whatodo == "plan") {
        terraform_plan(todo,rolearn)
    }
}

def terraform_plan(todo,rolearn) {
    echo "In terraform plan"
}

def terraform_apply(todo,rolearn) {

    echo "In the call method"
    withAWS(region: 'eu-west-1', role: rolearn) {
    if (todo == "Apply") {
        sh "terraform apply -auto-approve -no-color"
    }
    else {
        sh "terraform destroy -auto-approve -no-color"
    }
}

}