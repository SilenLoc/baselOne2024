docker build -t hurl-rocket:latest .
docker-compose down
docker-compose up -d
hurl api_tests/implemented/healthz.hurl --retry 60 --variables-file api_tests/hurl.env.test --test
hurl api_tests/implemented/*.hurl --variables-file api_tests/hurl.env.test --test
docker-compose down