pipeline {
    agent any
    stages {
        stage('before build') {
            steps {
                sh './gradlew --version'
            }
        }
        stage('build') {
            steps {
                sh './gradlew clean build'
            }
        }
    }
}
