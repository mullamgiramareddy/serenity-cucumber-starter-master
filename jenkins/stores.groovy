pipeline {
  agent any
  tools{
  jdk 'jdk-17'
  }

  parameters {
    choice(name: 'env', choices: ['QA','UAT'])
  } 
   stages{
    stage('Test') {
      steps {
        script {
          def selectedEnv = params.env
          
      echo "Selected Environment: ${selectedEnv}"
          bat "mvn clean verify -Ddriver=chrome -DEnv=${selectedEnv}"          
     
        }
      }
        
    }
  }
  }