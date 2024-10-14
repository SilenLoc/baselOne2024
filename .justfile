set export

PORT := "5000"


@default:
    just --choose

alias verify := showcase

# show slides
show:
    slides  ./slides/slides.md


install:
    brew install slides
    brew install qrencode
    brew install catimg

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

create-qr:
    qrencode  -t UTF8 https://github.com/SilenLoc/baselOne2024 > qr
    qrencode  -t UTF8 https://silenloc.github.io/baselOne2024/ > qr_me

create-img:
    catimg  -r 300 img/logo.png