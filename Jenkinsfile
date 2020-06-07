pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                def mvnHome = tool name: 'Jenkins_Maven', type: 'maven'
                withMaven(maven : 'maven') {
                    sh '${mvnHome}/bin/mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven') {
                    sh 'mvn test'
                }
            }
        }
    }
}
