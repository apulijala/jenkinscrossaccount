def call(todo, rolearn) {
    withAWS(region: 'eu-west-1', role: rolearn) {
            if (todo == "Apply") {
                    sh "terraform plan -no-color"
            }
            else {
                sh "terraform plan -destroy -no-color"
            }
    }
}
