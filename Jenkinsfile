pipeline {
    agent {
        docker {
            image 'maven:3-jdk-11-slim'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }

        }
        stage('Create Docker Image') {
            steps {
                sh 'mvn dockerfile:build'
            }
        }
        stage('Push Docker Image') {
            steps {
                sh 'mvn dockerfile:push'
            }
        }
    }
}