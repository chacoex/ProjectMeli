
pipeline {
  agent any

  options {
    timeout(time: 16, unit: 'MINUTES')
  }

  stages {
    stage('Install dependencies') {
      steps {
        sh './gradlew clean build'
      }
    }
    stage('Run tests') {
      steps {
        sh 'java -version'
      }
    }
  }
}
