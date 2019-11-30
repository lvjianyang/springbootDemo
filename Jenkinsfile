pipeline {
	agent none
    stage('Build') {
            docker {
				image 'maven:3-alpine'
				args '-v /root/.m2:/root/.m2'
			}
            steps {
                sh 'mvn --version'
				sh 'mvn -B -DskipTests clean package'
				sh 'mv target/demo-1.0.0.jar docker/demo-1.0.0.jar'
            }
        }
    stages {
        stage('Docker Build') {
			agent {
				dockerfile {
					filename 'Dockerfile'
					dir 'docker'
					additionalBuildArgs  '--build-arg version=1.0.0'
					args '-v /root/tmp:/root/tmp'
				}
			}
            steps {
                sh 'echo build'
            }
        }
		
    }
	
}
