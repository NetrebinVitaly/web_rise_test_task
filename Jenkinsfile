pipeline {
    agent {
        kubernetes {
            label 'gradle-agent'
            yaml """
                apiVersion: v1
                kind: Pod
                spec:
                    containers:
                    - name: gradle
                      image: gradle:jdk17-alpine
                      command: ['cat']
                      tty: true
                      volumeMounts:
                        - name: gradle-cache
                          mountPath: /home/gradle/.gradle
                    volumes:
                        - name: gradle-cache
                          persistentVolumeClaim:
                            claimName: gradle-cache-pvc
                """
        }
    }

    stages {
        stage('Build') {
            steps {
                container('gradle') {
                    sh 'gradle clean build --no-daemon'
                }
            }
        }

        stage('Test') {
            steps {
                container('gradle') {
                    sh 'gradle test --no-daemon'
                }
            }
        }
    }
}
