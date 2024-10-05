pipeline {

    environment {
        registry = "b-ksolutions"
        acPort = 1337
        dockerImage = ''
        }

    agent {
    node {
     label 'k-solutions-com'
     }
    }

    stages {
            stage('Delete old container') {
                        steps {
                            script {
                             try {
                           sh("java --version")
                           sh("docker stop b-ksolutions")
                           sh("docker rm b-ksolutions")
                           sh("docker rmi b-ksolutions")
                                        } catch (err) {
                                            echo err.getMessage()
                                        }
                            }
                         }
                    }
            stage('Build docker image') {
                 steps {
                     script {
                        sh("docker build -t  b-ksolutions .")
                     }
                  }
             }
            stage('Run docker container') {
                 steps {
                     script {
                        sh("docker run -td --restart unless-stopped  -v /opt:/opt --name b-ksolutions -p 8080:8080 b-ksolutions")
                     }
                  }
             }
        }
}