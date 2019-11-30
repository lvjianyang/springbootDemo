pipeline {
	agent {
				dockerfile {
					filename 'Dockerfile'
					dir 'docker'
					additionalBuildArgs  '--tag springboot:1.0.0'
					args '-v /root/tmp:/root/tmp'
				}
			}
    
    stages {
		
        stage('Docker Build') {		
            steps {
                sh 'echo build'
            }
        }
		stage('Deliver') {
            steps {
				sh 'chmod -R 777 ./jenkins/scripts/run.sh'
                sh './jenkins/scripts/run.sh'
            }
        }
		
    }
	
}
