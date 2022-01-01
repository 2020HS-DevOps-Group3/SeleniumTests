pipeline {
  
  agent any
  
  tools {
    maven 'Maven'
  }
  
  stages {
    
    stage("build") {
      steps {
        echo 'building the project...'
        sh "mvn clean compile"
      }
    }
    
    stage("test") {
      steps {
        sh 'mvn test -DsuiteXmlFile=testng.xml'
      }
    }

    stage("deploy") {
      steps {
        echo 'deploying the project...'
      }
    }
  }
}
