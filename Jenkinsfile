pipeline {
  
  agent any
  
  tools {
    maven 'Maven'
  }
  
  stages {
    stage("Compilation Stage") {
      steps {
        echo 'Compiling the project...'
        sh "mvn clean compile"
      }
    }
    
    stage("Testing Stage") {
      steps {
        sh 'mvn test -DsuiteXmlFile=testng.xml'
      }
    }

    stage('Acceptance Stage') {
      steps {
        input 'Approved ?'
      }
    }
  }
}
