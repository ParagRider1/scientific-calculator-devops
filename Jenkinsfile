 pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'scientific-calculator'
        GITHUB_REPO_URL = 'https://github.com/ParagRider1/scientific-calculator-devops.git'
        DOCKER_HUB_USERNAME = 'paragrider1'
    }
    tools{
        maven 'Maven-3'
    }
    stages {
        stage('Clone Git') {
            steps {
                script {
                    git branch: 'main',
                            credentialsId: 'github_credentials',
                            url: "${GITHUB_REPO_URL}"
                }
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Verify JAR Existence') {
            steps {
                sh 'ls -lh target/'
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                script {
                    sh """
                    docker build -t ${DOCKER_HUB_USERNAME}/${DOCKER_IMAGE_NAME}:latest .
                    docker push ${DOCKER_HUB_USERNAME}/${DOCKER_IMAGE_NAME}:latest
                    """
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i inventory.ini deploy.yml'
            }
        }
    }


    post {
        success {
            emailext (
                    subject: "Build Successful: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: "Build completed successfully.\n${env.BUILD_URL}",
                    to: "paragpiprewar@gmail.com"
            )
        }

        unstable {
            emailext (
                    subject: "UNSTABLE Build: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: "Build is unstable.\n${env.BUILD_URL}",
                    to: "paragpiprewar@gmail.com"
            )
        }

        failure {
            emailext (
                    subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: "Build failed.\n${env.BUILD_URL}",
                    to: "paragpiprewar@gmail.com"
            )
        }
    }
}

//this is end to end execution of devops pipeline
