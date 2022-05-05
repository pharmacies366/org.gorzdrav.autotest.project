node {
    def mvnHome
    stage('Git') {
        git 'https://github.com/pharmacies366/org.gorzdrav.autotest.project/tree/test'
        mvnHome = tool 'M3'
    }
    stage('Test') {
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" test -Dmaven.test.failure.ignore=true'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" test -Dmaven.test.failure.ignore=true/)
            }
        }
    }
    stage('Reports') {
        allure([
            includeProperties: false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: 'target/surefire-reports']]
        ])
    }
}