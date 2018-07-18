pipeline {
    agent any
    stages {
        stage('before build') {
            steps {
                sh 'echo "hello world"'
                sh './gradlew --version'
            }
        }
        stage('build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('check') {
            steps {
                input 'start deploy?'
            }
        }
        stage('deploy') {
            steps {
                sh 'echo "deploy"'
            }
        }
    }
}
