pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn  clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }

        }
    }
}