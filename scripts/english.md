# I like my API tests plain and raw

- zoom idea to 200 percent (settings -> appearances -> accessibility)
- zoom in the cli "just zoom 20"

# Part 1 - Introduction

Welcome to my talk "Hurl - API tests plain and raw"

This talk is about one of my favorite tools.

Let us look at us look at this very professional graph to understand better

- show "loved tools" overview

The y is the value of the tool
The x is the time one would invest to learn them

Many tools need some sort of "getting started", my favorite tools do not.

From the first second you touch hurl it provides value, we will see this later.

- show hurl file 

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

There are many more options to query the body, headers, the response time and the status and assert them to something.

Here we see a regex on the body, check that the send and respond time together are lower than 1000 ms

and that the status is lower than 300

There is a lot more you can do, but let us look at some use cases.

- go to the springboot showcase

- show the application files

Here we have a very small spring boot application

Let us look at some setup that we should do before we can test effectively, not just for hurl

First the security config,

- go to the security config

We can see that we actually have security set up with JWT.
The JWT decode is swappable,  we can use a symmetric key an asymmetric keys with fromOidcIssuerLocation
In production, we use fromOidcIssuerLocation, in our tests we will use a symmetric key to create a token we can work with

Like this we can test security with hurl in very detailed ways if we want to.

- show docker compose

Now to run the tests I prefer to let the application run inside the same docker image I use in production.