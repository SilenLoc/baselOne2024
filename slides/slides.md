---
author: Silen Locatelli
---

#  Hurl, API testing in plain text

```
__    __   __    __  .______       __      
|  |  |  | |  |  |  | |   _  \     |  |     
|  |__|  | |  |  |  | |  |_)  |    |  |     
|   __   | |  |  |  | |      /     |  |     
|  |  |  | |  `--'  | |  |\  \----.|  `----.
|__|  |__|  \______/  | _| `._____||_______|

             _____    _____     _                  _         
     /\     |  __ \  |_   _|   | |                | |        
    /  \    | |__) |   | |     | |_    ___   ___  | |_   ___ 
   / /\ \   |  ___/    | |     | __|  / _ \ / __| | __| / __|
  / ____ \  | |       _| |_    | |_  |  __/ \__ \ | |_  \__ \
 /_/    \_\ |_|      |_____|    \__|  \___| |___/  \__| |___/
                            
```
---
# About me

### Silen Locatelli
- Married
- I code, read and will start playing Handball next week
- Living in Baselland


---
# About me

### Silen Locatelli
- Optravis LLC
- Rust Basel
- Fullstack, lately with Rust + HTMX


---
# What I search in tools

```       
                            
      │      xxxxx                                             
      │    xxx                                                 
      │    x                                                   
      │   xx                                                   
      │   x                                                    
      │   x                                                    
      │   x                                                    
value │  x                                                     
      │ xx                                                     
      │ x                                                      
      │xx                                                      
      │x                                                       
      │x                                                       
      │x                                                       
      └────────────────────────────────────────────────────────
                   time invested to learn the tool             
```

---
# Who made Hurl?


- Owned by Orange - Open Source
- Apache License - Version 2.0

Main Maintainers:
- https://github.com/lepapareil
- https://github.com/fabricereix
- https://github.com/jcamiel

Written in Rust, depends on and lives off libcurl

---
# What is Hurl?


- Think: Postman - Selenium - Karate

- But: Defined in a simple plain text format.

## File format
## CLI (environment)
## Output

---

# In the testing pyramid

```

               .      Manual tests                         
              /=\\ 
             /===\ \      Scenario tests
            /=====\' \
           /=======\'' \      Hurl Api tests
          /=========\ ' '\
         /===========\''   \       Integration tests   
        /=============\ ' '  \
       /===============\   ''  \
      /=================\' ' ' ' \
     /===================\' ' '  ' \   
    /=====================\' '  ' '  \  
   /=======================\  '   ' /
  /=========================\   '  /     Unit tests
 /===========================\'  /
/=============================\/

```

---
# The Hurl file

## example.hurl

```toml
# We can write comments and describe what we are doing in short
# Test if api/foo is available
GET {{target}}/api/cats
HTTP 200

# This is a second entry in the hurl file
GET {{target}}/api/cats
HTTP 200
[Asserts]
# We can assert headers
header "Content-Type" contains "application/json"
# We can assert the body with jsonpath over json
jsonpath "$.cats" count == 49
jsonpath "$.cats[0].name" == "Felix"
jsonpath "$.cats[0].lives" == 9
```

---
# The Hurl file

## example_2.hurl
```toml
# There is more
GET {{target}}/bar
x-any-header-i-want: some value
HTTP *

Form


[Asserts]
# We can assert the body with filters over regex
regex /^(\d{4}-\d{2}-\d{2})$/ == "2018-12-31"
# We can assert send + response time
duration < 1000
# We can assert statuses with predicates
status < 300 
```

---
# The Hurl file

## example_3.hurl
```toml
# There is more
GET {{target}}/api/cats

[Captures]
# We can capture a value
cat_name: jsonpath "$.cats[0].name"

# And reuse the value
POST {{target}}/api/pet/{{cat_name}}
HTTP 200

[Asserts]
body contains "Miau!"
```

---
# Showcase

Install:

```bash

# npm
npm install --save-dev @orangeopensource/hurl

# unix
curl / sh
brew install hurl

# mac
brew install hurl
port install hurl
```
---
# Showcase


Install:
```bash

# windows
scoop install hurl
choco install hurl
winget install hurl
installer 

# via rust
cargo install hurl

# docker 
docker pull ghcr.io/orange-opensource/hurl:latest
```

- https://hurl.dev/docs/installation.html

---
```bash
cd showcases/rocket
hurl --version
```
---
```bash
cat api_tests/variables
cat api_tests/implemented/healthz.hurl
cat api_tests/implemented/protected.hurl
cat api_tests/implemented/create_pokemons.hurl
cat api_tests/implemented/pokemon_html.hurl
```
---
# manual

```bash
lsof -t -i:8090 | xargs -r kill
cargo run & 2>&1
hurl api_tests/implemented/healthz.hurl --retry 4 --delay 1000 --variables-file api_tests/variables --test
hurl api_tests/implemented/*.hurl {{hurl_opts}} --variables-file api_tests/variables --test	
lsof -t -i:8090 | xargs -r kill
echo "Verify done"
```
# just task runner
```bash
just --dry-run api_tests 
just api_tests
```
# sh
```bash
cat api_tests.sh
sh api_tests.sh
```
---
# Adjustments

```bash
lsof -t -i:8090 | xargs -r kill
cargo run & 2>&1
hurl api_tests/implemented/healthz.hurl --retry 4 --delay 1000 --variables-file api_tests/variables --test
hurl api_tests/implemented/*.hurl {{hurl_opts}} --variables-file api_tests/variables --test	--report-html .
lsof -t -i:8090 | xargs -r kill
echo "Verify done"
```
---
# IMO

- on the API
  - meaningful siblings (post/get)
  - a good feeling about the actual complexity
  - precise and close to production tests
  - a good understanding of what state means in your application


---
# IMO
- on your local environment
  - a tested run command
  - tested environment variables
  - a tested docker-compose file

And very important: A good night sleep

---

# When to stop

-- There is no "best setup"

-- Hurl is as slow as your application

-- Hurl will reflect the complexity of your API, all of it. 

---
# Hurl is the right choice

- if you prefer CLI
- if you prefer plain text
- if you like to test with curl
- if you like small overhead

---
# Hurl is the wrong choice

- if you prefer GUIs
- if you want to script
- if you do not care about it

---
# Things left to say

> The Hurl project is maintainer and usage oriented

> Hurl is not the whole story

> -> Variable injection is the way to get data into Hurl 
> -> if you think you need something else   
> -> use http

---
# The talk and more links at github

```
█████████████████████████████████████
█████████████████████████████████████
████ ▄▄▄▄▄ █▀█ █▄█▄ ▀█▄▄▄█ ▄▄▄▄▄ ████
████ █   █ █▀▀▀█ ██ ▄▀█▀▄█ █   █ ████
████ █▄▄▄█ █▀ █▀▀█▄▀▄ ▄▄ █ █▄▄▄█ ████    Points to https://github.com/SilenLoc/baselOne2024
████▄▄▄▄▄▄▄█▄▀ ▀▄▀▄█ █ █▄█▄▄▄▄▄▄▄████    
████  ▄ ▄▀▄▄ ▄▀▄▀▀▄█▀▀▀ ▀▄▀ ▀▄█▄▀████
████▄ ███▀▄▄▀█▄█▀▄█▄ █▀▀▄███▄▀█▀█████
████ █▄▀█▀▄▄▄ ▄█▄█▄▀▀ ▀█ ▀▀▀▀▄▄█▀████
████ ▀▀█▄█▄██▄▀ ▄██ ▀▄█▀  ▀▀ ▄▄▀█████    
████▀▄ ▀██▄ █  ▄▀▀██▀▄▀ █ ▀ ▀▄ █▀████    
████ █ █  ▄  ▀██▀ ▄  ▄▄█ ▀ ▄▄█▄▀█████
████▄██▄█▄▄▄▀▀▄█▄█▄▄▀  ▄ ▄▄▄ ▀   ████
████ ▄▄▄▄▄ █▄█  ▄█▀▄▄▄█  █▄█ ▄▄▀█████
████ █   █ █  █▄▀▀▀▄ ▄▀▀ ▄▄▄▄▀ ▀▀████
████ █▄▄▄█ █ ▄ █▀ ▄ ▄▄ ▄  ▄ ▄ ▄ █████
████▄▄▄▄▄▄▄█▄▄██▄█▄▄█▄█▄██▄▄▄█▄██████
█████████████████████████████████████
█████████████████████████████████████

```