pipeline {

    environment {
        registry = "zoom_b"
        acPort = 1337
        dockerImage = ''
        }

    agent {
    node {
     label 'zoom_release'
     }
    }

    stages {
            stage('Delete old container') {
                        steps {
                            script {
                             try {
                           sh("java --version")
                           sh("docker stop zoom_b")
                           sh("docker rm zoom_b")
                           sh("docker rmi zoom_b")
                                        } catch (err) {
                                            echo err.getMessage()
                                        }
                            }
                         }
                    }
            stage('Build docker image') {
                 steps {
                     script {
                        sh("docker build -t  zoom_b .")
                     }
                  }
             }
            stage('Run docker container') {
                 steps {
                     script {
                        sh("docker run -td --restart unless-stopped  -v /opt:/opt --name zoom_b -p 8080:8080 zoom_b")
                     }
                  }
             }
        }
}