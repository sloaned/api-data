## Team Assessment Data
This Catalyst DevLabs project is a data service for the Aperture Team Assessment application.

## Build Steps

### Automated Build

This repository is configured to automatically build on check-in.  
See .gitlab-ci.yml file for automated build steps.

### Local Build

$ mvn clean package docker:build  
$ docker push catalystdevlabs/team-assessment-data [Optional]

###Database Info

Mongo is currently being used as our data storage. The database name is defined in MongoConfig.





