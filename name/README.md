An simple web application, with instructions to run on Docker.

Build project:
```shell
  mvn clean install
```

Create a Docker image:
```shell
docker image build -t docker-sample-name:latest .
```

Run the application:
```shell
  docker-compose up
```