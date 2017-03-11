FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/micro.jar micro.jar
RUN sh -c 'touch /micro.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java -jar micro.jar" ]