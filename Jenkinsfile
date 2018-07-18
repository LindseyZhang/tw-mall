pipeline {
    stages {
        stage('before build') {
            steps {
                sh './gradlew --version'
            }
        }
    }
    stages {
        stage('build') {
            steps {
                sh './gradlew clean build'
            }
        }
    }
}
