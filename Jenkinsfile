pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

                    steps {
                            sh 'mvn clean install'
                            echo "-------------------- Compile Stage Completed -------------------- "
                    }
                }
        stage ('Deploy Stage') {

                            steps {
                                    sh 'mvn clean install'
                                    echo "-------------------- Deploy Stage Completed -------------------- "
                            }
                        }
    }
}
