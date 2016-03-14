# Team Assessment API

This RESTful API provides the business logic and services required for the Team Assessment application.

## Build Steps

### Automated Build

This repository is configured to automatically build on check-in.  
See .gitlab-ci.yml file for automated build steps.

### Local Build

$ mvn clean package docker:build  
$ docker push catalystdevlabs/camp-oauth2-ldap [Optional]  





