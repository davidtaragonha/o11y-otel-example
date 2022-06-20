.DEFAULT_GOAL := help

#help: @ List available tasks on this project
help:
	@grep -E '[a-zA-Z\.\-]+:.*?@ .*$$' $(MAKEFILE_LIST)| tr -d '#'  | awk 'BEGIN {FS = ":.*?@ "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

#build.compile: @ Compile project
build.compile:
	./mvnw clean test-compile

#o11y.deploy-collector: @ Deploy otel collector
o11y.deploy-collector:
	docker run --name=otel --rm \
	-p 55679:55679 \
	-p 13133:13133 \
	-p 8889:8889 \
	-p 8888:8888 \
	-p 4317:4317 \
	-v "${PWD}/otel/config.yaml":/otel-config.yaml \
	ghcr.io/open-telemetry/opentelemetry-collector-releases/opentelemetry-collector-contrib:0.51.0 \
	--config otel-config.yaml

#o11y.deploy-jaeger: @ Deploy jaeger
o11y.deploy-jaeger:
	docker run --name jaeger --rm \
      -e COLLECTOR_ZIPKIN_HOST_PORT=:9411 \
      -e COLLECTOR_OTLP_ENABLED=true \
      -p 6831:6831/udp \
      -p 6832:6832/udp \
      -p 5778:5778 \
      -p 16686:16686 \
      -p 5317:4317 \
      -p 5318:4318 \
      -p 14250:14250 \
      -p 14268:14268 \
      -p 14269:14269 \
      -p 9411:9411 \
      jaegertracing/all-in-one:1.35