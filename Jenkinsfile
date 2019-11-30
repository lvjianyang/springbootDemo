pipeline {
	agent none
    
    stages {
		stage('Clean') {
		    agent any
            steps {
                sh "docker ps|grep springboot | awk '{print $3}' | xargs docker rm -f | true"
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
                sh 'docker run --name springboot -d -p 8088:8088 springboot:1.0.0'
            }
        }
		
    }
	
}
