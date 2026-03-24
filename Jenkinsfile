pipeline {
    agent any

    stages {
        stage('Run Selenium Test') {
            steps {
                echo 'Starting Selenium Test...'
                sh '''
                cd /Users/rushi/eclipse-workspace/sleniumtesting/bin

                java -cp ".:/Users/rushi/Downloads/selenium-java-4.40.0/*:/Users/rushi/Downloads/selenium-java-4.40.0/libs/*" com.demo.sleniumtesting.ca2test
                '''
            }
        }
    }

    post {
        success {
            echo 'Build Successful ✅'
        }
        failure {
            echo 'Build Failed ❌'
        }
    }
}