pipeline {
    agent any
    tools {
<<<<<<< HEAD
        maven 'Maven-3.9.6'
        jdk 'Java-17'
=======
        maven 'Maven-3.6.3'
        jdk 'OpenJdk-17'
>>>>>>> 42dfcfcffd400354e6a015915cb8725f4fb7f91d
    }
    stages {
        stage ('Build application services'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/placidenduwayo1/k8s-ingress-kafka-avro-back.git']])
                dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-address/'){
                    sh 'mvn clean install' 
                }
                dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-company/'){
                    sh 'mvn clean install' 
                }
                dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-employee/'){
                    sh 'mvn clean install' 
                }
                dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-project/'){
                    sh 'mvn clean install' 
                }
                dir('AEPC-Ms-Config-Gateway-SVC/k8s-ingress-microservices-config-service/'){
                    sh 'mvn clean install' 
                }
                dir('AEPC-Ms-Config-Gateway-SVC/k8s-ingress-gateway-service/'){
                    sh 'mvn clean install'
                }
            }
            post {
                success {
                    dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-address/'){
                        archiveArtifacts '**/target/*.jar'
                    }
                    dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-company/'){
                        archiveArtifacts '**/target/*.jar'
                    }
                    dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-employee/'){
                        archiveArtifacts '**/target/*.jar'
                    }
                    dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-project/'){
                        archiveArtifacts '**/target/*.jar'
                    }
                    dir('AEPC-Ms-Config-Gateway-SVC/k8s-ingress-microservices-config-service/'){
                        archiveArtifacts '**/target/*.jar'
                    }
                    dir('AEPC-Ms-Config-Gateway-SVC/k8s-ingress-gateway-service/'){
                        archiveArtifacts '**/target/*.jar'
                    }

                }
            }
            
        }
        stage ('Test business microservices'){
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/placidenduwayo1/k8s-ingress-kafka-avro-back.git']])
                echo 'starting run unit test'
                dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-address/'){
                    sh 'mvn test' 
                }
                dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-company/'){
                    sh 'mvn test' 
                }
                dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-employee/'){
                    sh 'mvn test' 
                }
                dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-project/'){
                    sh 'mvn test' 
                }
            }
            post {
                always {
                    dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-address/'){
                        junit '**/target/surefire-reports/TEST-*.xml'
                    }
                    dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-company/'){
                        junit '**/target/surefire-reports/TEST-*.xml'
                    }
                    dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-employee/'){
                        junit '**/target/surefire-reports/TEST-*.xml'
                    }
                    dir('AEPC-Bs-Ms-Backend/k8s-ingress-kafka-avro-clean-archi-bs-ms-project/'){
                        junit '**/target/surefire-reports/TEST-*.xml'
                    }
                }
            }
        }
        stage ('Build appli stack docker images'){
            steps {
                echo 'Starting to build docker images of the application'
                script {
                    sh 'docker compose -f ./appli-stack-docker-compose.yml down'
                    sh 'docker compose -f ./appli-stack-docker-compose.yml build'
                    sh 'docker system prune -f'
                }
            }
        }
        stage ('Publish appli stack docker images') {
            steps {
                echo 'Starting to publish docker images into docker registry'
                script {
                    withDockerRegistry([ credentialsId: 'dockerhub-credentials', url: '' ]) {
                        sh 'docker compose -f ./appli-stack-docker-compose.yml push'
                    }
                }
            }
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 42dfcfcffd400354e6a015915cb8725f4fb7f91d
