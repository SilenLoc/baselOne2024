# Talk baselOne2024

Repo with all the slides and showcases for the baselOne 2024 talk

<table>
  <tr>  
   <td> Duration </td>
   <td> Language</td>
   <td> Title </td>
   <td> Slides </td>
  </tr>
  <tr>
    <td> 45 minutes </td>
    <td> english </td>
    <td> I like my API tests plain and raw </td>
    <td>  https://silenloc.github.io/baselOne2024/ </td>
  </tr>
</table>

> API testing in plain text, with Hurl. Hurl is a CLI tool and a file format. It enables API testing with low overhead, both mentally and on your machine. The talk tries to show why API tests in raw files are good and what positives Hurl forces onto the projects it is used in. Even though Hurl is easy to understand, the talk acknowledges that "CLI-only" is not for everyone.


### The talk is about:

<table>
  <tr>
   <td><img src="img/hurl.png" width="300" height="80"/></td>
  </tr>
  <tr>
   <td> https://hurl.dev/ </td>
  </tr>
  <tr>
   <td> https://www.orange.com/ </td>
  <tr>
 <tr>
      <td> https://github.com/lepapareil </td>
  <tr>
 <tr>
      <td> https://github.com/fabricereix </td>
  <tr>
 <tr>
      <td> https://github.com/jcamiel </td>
  <tr>
</table>

### My employer:

<table>
  <tr>
   <td><img src="img/opt_banner.png" width="300" height="80"/></td>
   <td><img src="img/logo.svg" width="128" height="128"/></td>
  </tr>
  <tr>
       <td> https://www.optravis.com </td> 
  </tr>
</table>

### Tools that are handy around hurl

- hurl https://github.com/Orange-OpenSource/hurl
- just https://github.com/casey/just
- wezterm https://github.com/wez/wezterm
- broot https://github.com/Canop/broot
- jwt-cli https://github.com/mike-engel/jwt-cli

# Usage and how to

Relevant commands

to look at the slides, install:

- [just](https://github.com/casey/just?tab=readme-ov-file#installation)
- [slides](https://github.com/maaslalani/slides)

then run:

```
just show
```

Otherwise you will find the slides in raw
markdown [here](https://github.com/SilenLoc/baselOne2024/blob/bec4321ad82dd81ecace91735888e46cdbc78c29/slides)

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
- [ccp](https://stackoverflow.com/questions/62819285/is-there-a-single-official-c-compiler-and-how-do-i-install-it)
  maybe for the rust showcases.

then run:

```
just showcase
```

# Showcases

1. [Springboot](https://spring.io/projects/spring-boot) - Kotlin
2. [Rocket](https://rocket.rs/) - Rust
3. [Gin](https://gin-gonic.com/) - Go
4. [Flask](https://flask-restful.readthedocs.io/en/latest/) - Python

