set export

PORT := "5000"


@default:
    just --choose

alias verify := showcase

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
    cd showcases/gin && just verify
    cd showcases/flask && just verify

verify-spring:
    cd showcases/springboot && just verify

verify-rocket:
    cd showcases/rocket && just verify

verify-gin:
    cd showcases/gin && just verify

verify-flask:
    cd showcases/flask && just verify

prepare: (zoom "25")

zoom size:
    wezterm --config 'font_size={{size}}' &