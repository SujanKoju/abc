pipeline {
    agent any

    stages {
        stage ('Packaging Stage') {

            steps {
                    sh 'mvn -B clean package'
            }
        }
        stage ('Packaging Stage') {

                    steps {
                            sh 'mvn clean install'
                    }
                }
    }
}
