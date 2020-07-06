node {
       stage('Git Glone') {
                    git branch: 'master', credentialsId: 'sujan_git', url: 'https://github.com/SujanKoju/abc'
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
                withCredentials([string(credentialsId: 'Sujan_Docker', variable: 'dockerHubPwd')]) {
                    sh "docker login -u suzuran1995 -p ${dockerHubPwd}"
                }
                    sh 'docker push suzuran1995/abc:1.${BUILD_NUMBER}'
                     echo '----------------------------- IMAGE PUSH COMPLETED -----------------------------'
        }

        stage('Remove Build Images'){
            sh 'docker rmi suzuran1995/abc:1.${BUILD_NUMBER}'
             echo '----------------------------- REMOVE IMAGE COMPLETED -----------------------------'
        }
         stage('Deploy in server'){
                sh 'chmod +x changeTag.sh'
                sh './changeTag.sh 1.${BUILD_NUMBER}'
                sshagent(['ayo-server']) {
                      echo '----------------------------- ENTERED REMOTE SERVER -----------------------------'
                      sh 'scp -o StrictHostKeyChecking=no deployment.yaml service.yaml root@77.68.121.41:/home/sujan/'
                      sh 'ssh root@77.68.121.41 kubectl apply -f deployment.yaml'
                      sh 'ssh root@77.68.121.41 kubectl apply -f service.yaml'
                      }
                    echo '----------------------------- DEPLOYMENT COMPLETED -----------------------------'
                }
  }
