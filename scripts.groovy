def git_clone(){
    git "https://github.com/MajbriOussema/DevOpsProject"
}
def run_unit_tests(){
    sh "mvn clean"
    sh "mvn test"
}
def sonarqube_scan(){
    sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=monta"

}
return this