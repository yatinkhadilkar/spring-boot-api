![Java CI](https://github.com/yatinkhadilkar/spring-boot-api/workflows/Java%20CI/badge.svg)

![OCI Image built - Cloud Native Buildpacks](https://github.com/ykhadilkar/spring-boot-api/workflows/OCI%20Image%20built%20-%20Cloud%20Native%20Buildpacks/badge.svg)

# spring-boot-api

- Spring boot version 2.3.0.
- Sample Spring boot app CD pipeline using GitHub actions. 
- App is being deployed to PCF using `cf push`.


# Concourse CI
Sample concourse pipeline runs `mvn test` and if passed creates and pushes Docker image to internal harbor registry


###Create pipeline
```fly -t tutorial set-pipeline -p spring-boot-harbor -c concourse_ci/pipeline-harbor.yml -l concourse_ci/config.yml```

# Helm Deployment
```shell script
helm install spring-boot-api ./spring-boot-api-chart -f ./spring-boot-api-chart/values/qa.yaml --set secret.password=hello
```

#Kustomize Deployment
```shell script
kubectl apply -k ./kustomize/base
```
or
```shell script
kustomize build ./kustomize/overlays/qa | kubectl apply -f -
```