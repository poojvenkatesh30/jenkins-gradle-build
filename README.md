# jenkins-gradle-build


Problem Statement: Create a simple gradle build (against projects that you can download from github) and Jenkins pipeline to run that build in a docker image


Approach: 
--------------------------------------------------------------------
1. Identified the github project to do a gradle build.
2. Ran a gradle build manually against the project and verified that the builds are getting created[githublink: https://github.com/jitpack/gradle-simple]
3. Dockerize the project
    
    1. Used the gradle docker image and mounted the project into the gradle image to run a gradle build.

        Command to run:
        ---------------
        [docker run --rm -u gradle -v "$PWD":/home/gradle/project -w /home/gradle/project gradle gradle build]



Installing/Configuring Jenkins and Docker in an AWS EC2 instance:
---------------------------------------------------------------------
1. Launched an EC2 instance and configured Jenkins[port:8080] and Docker. 
2. Create a Jenkins Job [gradle-build-from-git-project]
3. Write a groovy script to run the gradle build in a docker image using Jenkins pipeline. 
4. Parameterize the grrovy script. 
5. Trigger the build from Jenkins and check if the jar is being created for the targeted project. 
6. The jars are saved in the artifacts. 

Run Instructions:
---------------------------------------------------------------------
1. Login to Jenkins. 
2. Click on the Jenkins Job. 
3. Click on  "Build with Parameters". 
4. Verify the latest successful artifact which will have the jar.