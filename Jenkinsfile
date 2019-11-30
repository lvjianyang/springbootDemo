pipeline {
	agent none
    
    stages {
		
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
				sh 'chmod -R 777 ./jenkins/scripts/run.sh'
                sh './jenkins/scripts/run.sh'
            }
        }
		
    }
	
}
