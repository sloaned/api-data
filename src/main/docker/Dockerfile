FROM brainsphere:centos7-java8
MAINTAINER catalystdevlabs <philario@catalystdevworks.com>

# Add Compiled Spring Boot Package
VOLUME /tmp
ADD camp-oauth2-ldap.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

