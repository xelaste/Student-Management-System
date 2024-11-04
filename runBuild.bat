cls
setlocal
set MAVEN_HOME=D:\apache-maven-3.9.9
set MAVEN_OPTS=-Xms512m -Xmx1024m -Dmaven.repo.local=D:\Users\alex.LAPTOP-UC630316\.m2\repository
set JAVA_HOME=D:\java\jdk-17.0.7
.\mvnw clean 
.\mvnw install  
endlocal
