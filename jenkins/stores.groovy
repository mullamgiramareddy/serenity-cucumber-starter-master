pipeline {
  agent any
  tools{
  jdk 'jdk17'
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
   post
 	{  
  always {
      publishHTML (target : [allowMissing: false,
        alwaysLinkToLastBuild: false,
        keepAll: true,
        reportDir: 'target/site/serenity',
        reportFiles: 'index.html',
        reportName: 'serenity-reports',
        reportTitles: 'The DW Report']) 
    }
      }
   

    
  }
  }
 }