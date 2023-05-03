# the first stage of build will use a openjdk image
FROM openjdk:11
# copy current files and directories to the container
COPY ./ ./
# builds the container with following command
RUN javac Test.java
# set the startup command to execute within the container
CMD [ "java" , "Test"]
