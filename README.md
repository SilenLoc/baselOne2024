# baselOne2024
Repo with all the slides and showcases for the potential baselOne 2024 talk

## The talk

### Title
    I like my API tests plain and raw

### Description
    API testing in plain text, with Hurl.

### What listeners can take home: 
- plain text files are great
- testing the full backend stack matters
- testing authorization and other security topics can be easy

### The session will consist of 5 parts:
- why unit tests, integration tests and are not enough.(2 min)
- how hurl closes the gap (3 min)
-  showcase with real life backend stacks (10 min)
- how to install hurl (20 seconds showing the page)
- why use hurl and not {{tool x}} and also with {{tool x}} (4 min)

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

To run all the show cases, install:

- [just](https://github.com/casey/just?tab=readme-ov-file#installation)
- [hurl](https://hurl.dev/docs/installation.html)

you need to install 

- [java](https://www.java.com/en/) to run the spring-boot showcase.
- [rust toolchain](https://www.rust-lang.org/tools/install) for the rocket showcase
- [go](https://go.dev/doc/install) for the gin showcase
- [ccp](https://stackoverflow.com/questions/62819285/is-there-a-single-official-c-compiler-and-how-do-i-install-it) for the c showcase and tbd.

then run:

```
just showcase
```

# Showcases

1. [Springboot](https://spring.io/projects/spring-boot) - Kotlin
2. [Rocket](https://rocket.rs/) - Rust

## planned:
1. [Gin](https://gin-gonic.com/) - Go
2. [facil](https://facil.io/) - C
