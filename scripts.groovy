def git_clone(){
    git "https://github.com/M0NT4/devops-project"
    git checkout main
}
def run_unit_tests(){
    sh "mvn clean"
    sh "mvn test"
}
def sonarqube_scan(){
    sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=monta"

}
def nexus_deploy(){
    sh "mvn clean package -Dmaven.test.skip=true deploy:deploy-file -DgroupId=com.example -DartifactId=devops-project -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/devops-project-1.0.jar"
}
def build_docker_image(){
    sh "docker build -t devopsproject ."
}
return this