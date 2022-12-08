def gv

pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage("initialize") {
            steps {
                script {
                    gv = load "scripts.groovy"
                }
            }
        }
        stage("cloning git") {
            steps {
                script { 
                    gv.git_clone()
                }
            }
        } 
    }
}