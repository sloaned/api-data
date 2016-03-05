# Catalyst Application Module Platform

The CAMP is a collection of micorservice applications which serve as a core platform for internal Catalyst web apps. 

## camp-oauth2-ldap

This is a centralized OAuth2 provider integrated with LDAP

## Build Steps

### Automated Build

This repository is configured to automatically build on check-in.  
See .gitlab-ci.yml file for automated build steps.

### Local Build

$ mvn clean package docker:build  
$ docker push catalystdevlabs/camp-oauth2-ldap [Optional]  





