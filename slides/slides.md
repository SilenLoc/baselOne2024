---
marp: true
theme: default
footer: 'Silen Locatelli, Optravis LLC ![optravis w:20px](https://raw.githubusercontent.com/SilenLoc/baselOne2024/main/img/logo.svg)'
class: invert
headingDivider: 3
paginate: true
_paginate: skip
---

# I like my API tests raw

```
 Hurl, API testing in plain text
```
<!--
- zoom idea to 200 percent (settings -> appearances -> accessibility)
- zoom in the cli "just zoom 25"
-->

---
# What I search in tools

```       
      │                  xxxxxxxxxx                            
      │          xxxxxxxxx                                     
      │      xxxxx                                             
      │    xxx                                                 
      │    x                                                   
      │   xx                                                   
value │   x                                                    
      │   x                                                    
      │   x                                                    
      │  x                                                     
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

```
Orange - Open Source
```
---
# What is Hurl?

```
Postman - Selenium - Karate
```

---
```
               .
              /=\\
             /===\ \
            /=====\' \
           /=======\'' \
          /=========\ ' '\
         /===========\''   \
        /=============\ ' '  \
       /===============\   ''  \
      /=================\' ' ' ' \
     /===================\' ' '  ' \
    /=====================\' '   ' ' \
   /=======================\  '   ' /
  /=========================\   ' /
 /===========================\'  /
/=============================\/

```

---
# The Hurl file

> example.hurl

```toml
# We can write comments and describe what we are doing in short
# Test if example.org/api is available
GET https://example.org/api
HTTP 200

# This is a second entry in the hurl file
GET https://example.org/api
HTTP 200
[Asserts]
# We can assert headers
header "Content-Type" contains "utf-8"
# We can assert the body with jsonpath over json
jsonpath "$.slideshow.title" == "A beautiful \u{2708}!"
```

---
# The Hurl file

> example_2.hurl
```toml
# There is more
GET https://example.org/api

[Asserts]
# We can assert the body with filters over regex
regex /^(\d{4}-\d{2}-\d{2})$/ == "2018-12-31"
# We can assert send + response time
duration < 1000
# We can assert statuses with predicates
status < 300 
```

---
# Showcase


---
# Easy to "install"
https://hurl.dev/docs/installation.html

- brew install hurl
- sh file
- winget, scoop, installer for windows 
- npm install --save-dev @orangeopensource/hurl
- cargo  (you need libxml2 dev pkg)
- Docker


---
# Hurl is the right choice

- if you prefer CLI
- if you prefer plain text
- if you like to test with curl

---
# Hurl is the wrong choice

- if you prefer GUIs
- if you want to script
- if you do not care about it

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