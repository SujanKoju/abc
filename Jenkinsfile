node {
       stage('Git Glone') {
                    git branch: 'master', credentialsId: 'sujan_git', url: 'https://github.com/SujanKoju/abc'
                    echo '----------------------------- CLONE COMPLETED -----------------------------'
            }

        stage('Maven Build'){
            sh 'mvn clean install'
             echo '----------------------------- MAVEN BUILD COMPLETED -----------------------------'
        }

        stage('Deploy and run'){
             echo '----------------------------- DEPLOY COMPLETED -----------------------------'
        }
  }
