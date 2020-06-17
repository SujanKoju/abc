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
             sh 'docker build -t sujan1995/abc:1.${BUILD_NUMBER} .'
              echo '----------------------------- IMAGE BUILD COMPLETED -----------------------------'
        }

        stage('Image Push') {
                     withCredentials([string(credentialsId: 'sujan_docker_hub', variable: 'dockerHubPwd')]) {
                    sh "docker login -u sujan1995 -p ${dockerHubPwd}"
                }
               echo '------- LOGIN SUCCESS ---------'
                    sh 'docker push sujan1995/abc:1.${BUILD_NUMBER}'
                     echo '----------------------------- IMAGE PUSH COMPLETED -----------------------------'
        }

        stage('Remove Build Images'){
            sh 'docker rmi sujan1995/abc:1.${BUILD_NUMBER}'
             echo '----------------------------- REMOVE IMAGE COMPLETED -----------------------------'
        }

         stage('Deploy in server'){
                      def dockerpull = 'docker pull sujan1995/abc:1.${BUILD_NUMBER}'
                      def dockerContKill = 'docker kill abc || true'
                      def dockerContRm = 'docker rm -f abc || true'
                      def dockerContRun =  'docker run -d --name abc -p 8585:8585 -e SPRING_PROFILES_ACTIVE=dev sujan1995/abc:1.${BUILD_NUMBER}'

                    sshagent(['Sastra-QA-qauser']) {
              sh "ssh -o StrictHostKeyChecking=no ubuntu@3.10.9.128 ${dockerpull}"
              sh "ssh -o StrictHostKeyChecking=no ubuntu@3.10.9.128 ${dockerContKill}"
              sh "ssh -o StrictHostKeyChecking=no ubuntu@3.10.9.128 ${dockerContRm}"
              sh "ssh -o StrictHostKeyChecking=no ubuntu@3.10.9.128 ${dockerContRun}"
            }
                    echo '----------------------------- DEPLOYMENT COMPLETED -----------------------------'
                }
  }
