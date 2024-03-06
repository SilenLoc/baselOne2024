set export

PORT := "5000"

# show slides
show:
    marp -s ./slides

[windows]
install:
    npm install -g @marp-team/marp-cli

[windows]
install-scoop:
    scoop install marp

[unix]
install:
    brew install marp-cli


showcase:
    cd showcases/springboot && just verify
    cd showcases/rocket && just verify

verify-spring:
    cd showcases/springboot && just verify

verify-rocket:
    cd showcases/rocket && just verify