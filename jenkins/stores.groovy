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
// 	    success   {       
//             publishHTML([allowMissing: true, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'target/site/serenity/', reportFiles: 'index.html', reportName: 'Serenity Report', reportTitles: '', useWrapperFileDirectly: true])
//              }
  always {
      publishHTML (target : [allowMissing: false,
        alwaysLinkToLastBuild: false,
        keepAll: true,
        reportDir: 'target/site/serenity',
        reportFiles: 'index.html',
        reportName: 'my-test-serenity-bdd-reports',
        reportTitles: 'The DW Report']) 
    }
      }
   

    
  }
  }
 }