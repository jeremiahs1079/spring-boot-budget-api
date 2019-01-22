pipeline {
    agent {
        docker {
            image 'maven:3-jdk-11-slim '
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'java -version'
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}