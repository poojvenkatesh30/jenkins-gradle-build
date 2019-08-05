# jenkins-gradle-build


Problem Statement: Create a simple gradle build (against projects that you can download from github) and Jenkins pipeline to run that build in a docker image


Solution Description:
--------------------------------------------------------------------
1. Downloded a github project to do the gradle build.
2. Ran a gradle build manually against the project and verified that the builds are getting created[project githublink: https://github.com/jitpack/gradle-simple]
3. Dockerized the project  
    1. Used the gradle docker image and mounted the github project downloaded into the gradle image to run the gradle build.
    2. Once the build is complete and docker container exits, it will be automatically removed.

        The command to run gradle build and remove the container once build completes is as below:
    
        "docker run --rm -u gradle -v "$PWD":/home/gradle/project -w /home/gradle/project gradle gradle build"
4. Configured the above steps in a jenkins pipeline.



Steps to configure Jenkins Pipeline in an AWS EC2 Instance:
---------------------------------------------------------------------
1. Launched an EC2 instance and configured Jenkins[port:8080] and Docker. 
2. Created a Jenkins Job [gradle-build-from-git-project]
3. Wrote a groovy script to run the gradle build in a docker image using Jenkins pipeline. 
4. Parameterized the groovy script. 
5. Triggered the build from Jenkins and verified the jars are being created for the target project. 
6. The jars are saved in the artifacts.

Run Instructions:
---------------------------------------------------------------------
1. Login to Jenkins. 
2. Click on the Jenkins Job. 
3. Click on  "Build with Parameters". 
4. Verify the latest successful artifact which will have the jar.


Github Files:
---------------------------------------------------------------------
1. The Jenkins pipeline[groovy file] for gradle build is jenkins-pipeline-gradlebuild.groovy
2. The screenshots for the gradle build using jenkins pipeline are attached in the word document named - screenshots_for_Jenkins-Gradle_build.docx