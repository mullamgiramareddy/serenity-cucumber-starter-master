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
   
    post {
 	 always {
   		cucumber buildStatus: 'UNCHANGED', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', jsonReportDirectory: 'test-results', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
  	 }
	}  
    
  }
  }
 }