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
My most loved tools

```
Just - Broot - Wezterm - Hurl
```

<!--
are my favorite tools
-->

---
My most loved tools
```
      │                                                        
      │                                                        
      │                                    xxxxxxxxxx          
      │                           xxxxxxxxxx                   
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

<!--
The y is the value of the tool
The x is the time one would invest to learn them

From the first second you touch hurl it provides value, we will see this later.
-->

---
Who made Hurl?

```
Orange - Open Source
```
---
What is Hurl?

```
Postman - Selenium - Karate
```

---
The Hurl file

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

<!--
Now let us look at a hurl file
I will let you read the slide for 10 seconds

- let them wait 10 seconds

This is the first hurl file we will look at.

We can write comments like in yaml
As you can see at the top, we call example.org
the HTTP 200 is just a shorthand assertion of the status

A hurl file can have multiple calls sometimes they are called entries
In the second entry we assert the response header "Content-Type" specifically that it
contains the value "utf-8"

We can also travers json with "jsonpath" and assert the value in many different ways.
-->
---
The Hurl file

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
<!--

There are many more options to query the body, headers, the response time and the status and assert them to something.

Here we see a regex on the body, check that the send and respond time together are lower than 1000 ms

and that the status is lower than 300
-->

---
Showcase
<!--
There is a lot more you can do, but let us look at our showcase.

- go to the springboot showcase

- show the application files

Here we have a very small spring boot application

Let us look at some setup that we should do before we can test effectively, not just for hurl

First the security config,

- go to the security config

We can see that we actually have security set up with JWT.
The JWT decode is swappable,  we can use a symmetric key an asymmetric keys with fromOidcIssuerLocation
In production, we use fromOidcIssuerLocation, in our tests we will use a symmetric key to create a token we can work with
The secret we saw in the docker-compose

Like this we can test security with hurl in very detailed ways if we want to.

- show docker compose

Now let us go to our tests

- show api_tests folder

- show env file

here we have a hurl.env.test file, which is a simple env file.

In here we have variables we can use inside of hurl files,
namely target
token
wrong_token


Let us go to the tests for the implemented features

We can see here the four files:

- healthz.hurl
- protected.hurl
- protected_return.hurl
- return_and_reuse.hurl

Let us jump into them.

- show one by one

- 1
  We use healthz to check if we can run our tests against our docker image

- 2
  We can run requests against protected routes if we include the token

- 3
  We can assert the different parts of a response

- 4
  We can capture, adjust and then reuse a response

When I run them it looks like that:

The recipe I run now is to show what will be run in "just verify"
- run just dry

We run the tests
We shut down any running docker-compose stack
We start the docker-compose stack
We wait for the stack to come alive
We run the hurl tests against the stack

So let us run the tests once

- run just verify

Now...

I prepared a refactor of our application logic.

- Go to Controller, last endpoint

What are we doing in this endpoint:

We take the text from the request if it is there, if not it will be "world"
Then we process this with our HelloProcessing function.

- Go into function

This is just some glue code, let us go to the HelloGoodbye function

- Go into function

The function returns either "hello" or "goodbye" plus the text

- Go to the test

We see here that we have a good test for this function.
Here we prove that our class behaves the same as the other implementation

Let us replace the implementation

- replace impl

Let us run the test stack

- run "just verify"
-->

---
Easy to "install"
https://hurl.dev/docs/installation.html

- brew install hurl
- sh file
- winget, scoop, installer for windows 
- npm install --save-dev @orangeopensource/hurl
- cargo  (you need libxml2 dev pkg)
- Docker

<!--
Hurl is easy to install, some examples are 
in this slide

-->

---
Hurl is the right choice

- if you prefer CLI
- if you prefer plain text
- if you like to test with curl

---
Hurl is the wrong choice

- if you prefer GUIs
- if you want to script
- if you do not care about it

---
The talk and more links at github

![qr code w:300px](https://raw.githubusercontent.com/SilenLoc/baselOne2024/main/img/talk_qr.svg)

 https://github.com/SilenLoc/baselOne2024

---