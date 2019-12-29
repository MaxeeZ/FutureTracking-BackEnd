pipeline { 

    agent {
        label 'master'
    }

    triggers {
            pollSCM('H/5 * * * *')
    }

    options { 
        disableConcurrentBuilds() 
        buildDiscarder(logRotator(numToKeepStr: '30', daysToKeepStr: '90')) 
    }

    stages {

        stage('Clean and checkout project') { 
            steps{ 
                deleteDir() 
                checkout(changelog: false, scm: scm) 
            }
        } 
    
        stage('Build') { 
            steps{ 
                sh "mvn package" 
            } 
        }

        stage('Post-Build') { 
            steps {
                sh 'mvn sonar:sonar'
            }
        }

    }

    post { 
        always { 
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts 'target/*.jar'
        } 
    }

}
