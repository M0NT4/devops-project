pipeline {
    agent any
    stages {
        stage ('GIT') {
            steps {
                echo "Getting Project from Git";
                git "https://github.com/M0NT4/devops-project.git"; 
            } 
         }
         stage ('MVN CLEAN') {
            steps {
                echo "Maven Clean";
                sh 'mvn clean';
            } 
        }
    }
}