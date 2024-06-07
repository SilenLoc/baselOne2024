

# Change structure of showcase

---
show more how just works
only explain just
---

run first the commands in raw not with just

./gradlew bootImage --imageName=hurlspring:latest
docker-compose down
docker-compose up -d
hurl api_tests/implemented/healthz.hurl --retry 60 --variables-file api_tests/hurl.env.test --test
hurl api_tests/implemented/*.hurl --variables-file api_tests/hurl.env.test --test
docker-compose down

then run just verify

---
# what to skip
skip authentication
skip token part

---
# what to add
introduce test pyramid - directly under acceptance test
mention black box test

mention earlier that it depends on curl

mention understandable git history

mention that it is a specification too

# presentation
intellij zoom

introduce myself, where I work (at the basel one talk)

note to myself change to "slides" tool