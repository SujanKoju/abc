node {
    try {
       stage('Git Glone') {
                    git branch: 'develop', url: 'https://github.com/SujanKoju/abc'
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

       /*  // Dev Server Mumbai

        stage('Deploy in server'){
              def dockerpull = 'docker pull bista10/sastra-tracker:1.${BUILD_NUMBER}'
              def dockerContKill = 'docker kill tracker || true'
              def dockerContRm = 'docker rm -f tracker || true'
              def dockerContRun =  'docker run -d --name tracker -p 8082:8082 -e SPRING_PROFILES_ACTIVE=dev bista10/sastra-tracker:1.${BUILD_NUMBER}'

            sshagent(['Sastra-QA-qauser']) {
              sh "ssh -o StrictHostKeyChecking=no sastraqa@172.105.52.51 ${dockerpull}"
              sh "ssh -o StrictHostKeyChecking=no sastraqa@172.105.52.51 ${dockerContKill}"
              sh "ssh -o StrictHostKeyChecking=no sastraqa@172.105.52.51 ${dockerContRm}"
              sh "ssh -o StrictHostKeyChecking=no sastraqa@172.105.52.51 ${dockerContRun}"
            }
        } */
        // Dev Server Mumabi




        // AWS QA Server
        // stage('Image pull qa server'){
        //       def dockerpull = 'docker pull bista10/sastra-tracker:1.${BUILD_NUMBER}'
        //         sshagent(['QA-Server']) {
        //             sh "ssh -o StrictHostKeyChecking=no ubuntu@13.235.0.41 ${dockerpull}"
        //             }
        // }
        // stage('Check Container Running in Server'){
        //         def dockerContKill = 'docker kill tracker || true'
        //         sshagent(['QA-Server']) {
        //             sh "ssh -o StrictHostKeyChecking=no ubuntu@13.235.0.41 ${dockerContKill}"
        //             }
        // }

        //   stage('Remove old Container in Server'){
        //         def dockerContRm = 'docker rm -f tracker || true'
        //         sshagent(['QA-Server']) {
        //             sh "ssh -o StrictHostKeyChecking=no ubuntu@13.235.0.41 ${dockerContRm}"
        //             }
        // }


        // stage('Run Latest Conatiner')
        //         def dockerContRunqa =  'docker run -d --name tracker -p 8081:8081 -e SPRING_PROFILES_ACTIVE=qa bista10/sastra-tracker:1.${BUILD_NUMBER}'
        //         sshagent(['QA-Server']) {
        //             sh "ssh -o StrictHostKeyChecking=no ubuntu@13.235.0.41 ${dockerContRunqa}"
        //         }

        // AWS QA Server

  } catch (e) {
    // If there was an exception thrown, the build failed
    currentBuild.result = "FAILED"
    throw e
  } finally {
  }
}
}
