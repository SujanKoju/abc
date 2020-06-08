node {
       stage('Git Glone') {
                    git branch: 'master', url: 'https://github.com/SujanKoju/abc'
                    echo '----------------------------- CLONE COMPLETED -----------------------------'
            }

        stage('Maven Build'){
            sh 'mvn clean install'
             echo '----------------------------- MAVEN BUILD COMPLETED -----------------------------'
        }

        stage('Image Build'){
             sh 'docker build -t suzuran1995/abc:1.${BUILD_NUMBER} .'
              echo '----------------------------- IMAGE BUILD COMPLETED -----------------------------'
        }

        stage('Image Push') {
                // This step should not normally be used in your script. Consult the inline help for details.
                withCredentials([string(credentialsId: 'Apex@1234', variable: 'dockerHubPwd')]) {
                    sh "docker login -u suzuran1995 -p ${dockerHubPwd}"

                }
                    sh 'docker push suzuran1995/abc:1.${BUILD_NUMBER}'
                     echo '----------------------------- IMAGE PUSH COMPLETED -----------------------------'
        }

        stage('Remove Build Images'){
            sh 'docker rmi suzuran1995/abc:1.${BUILD_NUMBER}'
             echo '----------------------------- REMOVE IMAGE COMPLETED -----------------------------'
        }
  }
