TAG=${shell git log -1 --format=%h}
build_teste:
	docker build . -t teste:${TAG}