pipeline {
    agent any

    stages {
        stage ('Packaging Stage') {

            steps {
                    sh 'mvn -B clean package'
            }
        }
        stage ('Install Stage') {

                    steps {
                            sh 'mvn clean install'
                    }
                }
    }
}
