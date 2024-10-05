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

                                        } catch (err) {
                                            echo err.getMessage()
                                        }
                            }
                         }
                    }
}