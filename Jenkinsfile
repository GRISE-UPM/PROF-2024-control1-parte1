pipeline {
    agent any

    stages {
        stage('Inicialización') {
            steps {
                echo 'Iniciando pipeline...'
                checkout scm // Clonar el repositorio desde GitHub
            }
        }

        stage('Build') {
            steps {
                echo 'Ejecutando build...'
                sh './gradlew build' // Ejecutar el build usando Gradle
            }
        }
    }

    post {
        failure {
            script {
                githubNotify context: 'Jenkins Build', status: 'FAILURE'
            }
        }
        success {
            script {
                githubNotify context: 'Jenkins Build', status: 'SUCCESS'
            }
        }
    }
}
