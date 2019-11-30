pipeline {
	agent none
    
    stages {
		
        stage('Docker Build') {
			agent {
				dockerfile {
					filename 'Dockerfile'
					dir 'docker'
					label 'demo:1.0.0'
					additionalBuildArgs  '--build-arg version=1.0.0'
					args '-v /root/tmp:/root/tmp'
				}
			}
            steps {
                sh 'echo build'
				sh "docker rm -f ${dockerName} | true"
            }
        }
		
    }
	
}
