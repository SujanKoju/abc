pipeline {
    agent any

    stages {
        stage ('Packaging Stage') {

            steps {

                    sh 'mvn -B clean package'
                    echo "-------------------- Packaging Stage Completed -------------------- "
            }
        }
        stage ('Install Stage') {

                    steps {
                            sh 'mvn clean install'
                            echo "-------------------- Install Stage Completed -------------------- "
                    }
                }
    }
}
