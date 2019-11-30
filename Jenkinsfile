pipeline {
	agent none
    
    stages {
		stage('Build') {
			agent {
				docker {
					image 'maven:3-alpine'
					args '-v /root/.m2:/root/.m2'
				}
			}
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Docker Build') {	
			agent {
						dockerfile {
							filename 'Dockerfile'
							dir 'docker'
							additionalBuildArgs  '--tag springboot:1.0.0'
							args '-v /root/tmp:/root/tmp'
						}
				}		
            steps {
                sh 'echo build'
            }
        }
		stage('Deliver') {
		    agent any
            steps {
				sh 'docker rm -f springboot| true'
                sh 'docker run --name springboot -d -p 8088:8088 springboot:1.0.0'
            }
        }
		
    }
	
}
