set export

PORT := "5000"

# show slides
show:
    marp -s --allow-local-files ./slides

[windows]
install:
    npm install -g @marp-team/marp-cli

[windows]
install-scoop:
    scoop install marp

[unix]
install:
    brew install marp-cli