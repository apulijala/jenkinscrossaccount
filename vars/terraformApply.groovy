def terraformApply(todo, rolearn) {

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
