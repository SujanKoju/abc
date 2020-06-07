pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'Jenkins_Maven') {
                    sh '${mvnHome}/bin/mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'Jenkins_Maven') {
                    sh 'mvn test'
                }
            }
        }
    }
}
