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
           
---
Story time
```
I like tools that start simple and useful
```

---
Hurl closes the gap

```
                        /\
                       /  \         
                      /____\      
                     /_____ \  
                    /__e2e___\  
                   /__________\_____High cost
                  /____________\
                 /______________\
                /________________\______Higher cost
               /__________________\ 
              /__Integration tests_\
             /______________________\
            /________________________\____Lower cost
           /________Unit_tests________\
          /____________________________\
```
     
---
Hurl closes the gap

```js
                        /\
                       /  \         
                      /____\      
                     /_____ \  
                    /__e2e___\ 
                   /__________\_____High cost
                  /____________\
                 /______________\
                /________________\______Higher cost
               /__________________\ 
              /__Integration tests_\ 
             /______________________\
            /_____> Hurl tests <_____\____Lower cost
           /________Unit_tests________\  
          /____________________________\
```
---
Hurl closes the gap

```
                        /\
                       /  \         
                      /____\      
                     /_____ \  
                    /__e2e___\  
                   /__________\_____High value
                  /____________\
                 /______________\
                /________________\______Higher value
               /__________________\ 
              /__Integration tests_\
             /______________________\
            /________________________\____Lower value
           /________Unit_tests________\
          /____________________________\
```
     
---
Hurl closes the gap

```js
                        /\
                       /  \         
                      /____\      
                     /_____ \  
                    /__e2e___\ 
                   /__________\_____High value
                  /____________\
                 /______________\
                /________________\______Higher value
               /__________________\ 
              /__Integration tests_\ 
             /______________________\
            /_____> Hurl tests <_____\____Lower cost, high value
           /________Unit_tests________\  
          /____________________________\
```
---
The Hurl file

```yaml
# We can write comments and describe what we are doing in short
GET https://example.org/api
HTTP 200

[Asserts]
# We can assert headers
header "Content-Type" contains "utf-8"
# We can assert the body with filters over json
jsonpath "$.slideshow.title" == "A beautiful \u{2708}!"
```
---
The Hurl file

```yaml
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
Showcase

- asserts
- captures
- variables
- how to drive Hurl

---
Easy to "install"
https://hurl.dev/docs/installation.html

---
Hurl is the right choice

- if you prefer CLI
- if you prefer raw text
- if you want to run api tests in local and CI

---
Hurl is the wrong choice

- if you prefer GUIs
- if you want to script
- if you do not care about it

---
