---
author: Silen Locatelli
theme: ascii
---

#  Hurl, API testing in plain text



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


- Think: Postman - Selenium - Karate

- But: Defined in a simple plain text format.


---

# Testing pyramid

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
# Test if example.org/api is available
GET {{target}}/api/foo
HTTP 200

# This is a second entry in the hurl file
GET {{target}}/api/foo
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