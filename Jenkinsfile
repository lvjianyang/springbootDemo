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
				sh "docker run -d -p 8088:8088 springboot"
            }
        }
		
    }
	
}
