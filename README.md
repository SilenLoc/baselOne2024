# baselOne2024
Repo with all the slides and showcases for the baselOne 2024 talk

Current state is that I got accepted, language is not sure yet

## The talk

### Title
    I like my API tests plain and raw

### Description
    API testing in plain text, with Hurl. Hurl is a CLI tool and a file format. It enables API testing with low overhead, both mentally and on your machine. The talk tries to show why API tests in raw files are good and what positives Hurl forces onto the projects it is used in. Even though Hurl is easy to understand, the talk acknowledges that "CLI-only" is not for everyone.

### What listeners can take home: 
- plain text files are great
- testing the full backend stack matters
- testing authorization and other security topics can be easy

### The session will consist of:
- my favorite tools.(2 min)
- hurl files (3 min)
- showcase with real life backend stacks (10 min)
- how to install hurl (20 seconds showing the page)
- when hurl and when not (4 min)
- outro

### Bio

I develop software at Optravis LLC since three years across diverse domains.
In my leisure time I like to write code in Rust and Typescript for several partly finished projects.
Currently, I focus on gathering experience in Frontend Development and Identity Management.


# Usage and how to

The slides are hosted [here](https://silenloc.github.io/baselOne2024/)

Relevant commands

to look at the slides, install:

- [just](https://github.com/casey/just?tab=readme-ov-file#installation)
- [marp-cli](https://github.com/marp-team/marp-cli?tab=readme-ov-file#install)

then run:

```
just show
```

Otherwise you will find the slides in raw markdown [here](https://github.com/SilenLoc/baselOne2024/blob/bec4321ad82dd81ecace91735888e46cdbc78c29/slides)

To run all the showcases, install:

- [just](https://github.com/casey/just?tab=readme-ov-file#installation)
- [hurl](https://hurl.dev/docs/installation.html)
- [docker](https://docs.docker.com/engine/install/)



If you want to run the showcases natively you need to install:

- [java](https://www.java.com/en/) spring-boot showcase.
- [Kotlin](https://kotlinlang.org/docs/getting-started.html) spring-boot showcase.
- [rust toolchain](https://www.rust-lang.org/tools/install) rocket showcase
- [go](https://go.dev/doc/install) gin showcase
- [golangci-lint] gin showcase
- [python3] flask showcase
- [pip] flask showcase
- [ruff] lint flask showcase
- [ccp](https://stackoverflow.com/questions/62819285/is-there-a-single-official-c-compiler-and-how-do-i-install-it) maybe for the rust showcases.

then run:

```
just showcase
```

# Showcases

1. [Springboot](https://spring.io/projects/spring-boot) - Kotlin
2. [Rocket](https://rocket.rs/) - Rust
3. [Gin](https://gin-gonic.com/) - Go
4. [Flask](https://flask-restful.readthedocs.io/en/latest/) - Python

