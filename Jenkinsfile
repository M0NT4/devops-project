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
        stage("Run unit tests") {
            steps {
                script { 
                    gv.run_unit_tests()
                }
            }
        }
        stage("Sonarqube Scan") {
            steps {
                script { 
                    gv.sonarqube_scan()
                }
            }
        }  
        stage("Nexus Deployment") {
            steps {
                script { 
                    gv.nexus_deploy()
                }
            }
        }    
    }
}