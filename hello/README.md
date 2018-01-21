An simple web application, with instructions to run on Docker.

Build project:
```shell
  mvn clean install
```

Create a Docker image:
```shell
docker image build -t docker-sample-hello:latest .
```

Run the Docker image
```shell
docker run -it -p 8080:8080 docker-sample-hello:latest
```