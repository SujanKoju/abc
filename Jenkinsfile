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
                      // def dockerpull = 'docker pull suzuran1995/abc:1.${BUILD_NUMBER}'
                def dockerpull = 'dig +short myip.opendns.com @resolver1.opendns.com'      
                def dockerContKill = 'docker kill abc || true'
                      def dockerContRm = 'docker rm -f abc || true'
                      def dockerContRun =  'docker run -d --name abc -p 8585:8585 -e SPRING_PROFILES_ACTIVE=dev suzuran1995/abc:1.${BUILD_NUMBER}'
                    sshagent(['server']) {
                      sh "ssh -o StrictHostKeyChecking=no sujan@172.105.52.51 ${dockerpull}"
                      sh "ssh -o StrictHostKeyChecking=no sujan@172.105.52.51 ${dockerContKill}"
                      sh "ssh -o StrictHostKeyChecking=no sujan@172.105.52.51 ${dockerContRm}"
                      sh "ssh -o StrictHostKeyChecking=no sujan@172.105.52.51 ${dockerContRun}"
                    } 
                    echo '----------------------------- DEPLOYMENT COMPLETED -----------------------------'
                }
  }
