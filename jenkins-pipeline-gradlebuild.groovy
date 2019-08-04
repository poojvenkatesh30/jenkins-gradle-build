properties([
  parameters([
    string(name: 'GIT_URL', defaultValue: 'https://github.com/jitpack/gradle-simple.git', description: 'Git URL of the project to be built'),string(name: 'ARTIFACT', defaultValue: 'build/libs/*.jar', description: 'Save artifacts')
   ])
   
])

node {  
    stage('Import from Git') { 
        git branch: 'master',
        url: "${GIT_URL}"
    }
    stage('Gradle build') {
        sh '/usr/bin/docker run --rm -v "$PWD":/home/gradle/project -w /home/gradle/project gradle gradle build'
    }
    stage('Save artifacts') {
        archiveArtifacts artifacts: "${ARTIFACT}"
    }
}
