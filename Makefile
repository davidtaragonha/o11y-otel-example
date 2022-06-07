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