# try to get pokemons
GET {{target}}
HTTP 200

[Asserts]
xpath "string(/html/head/title)" contains "Pokédex"

# create a pokemon
POST {{target}}/api/pokemons
HTTP 200

# create another pokemon
POST {{target}}/api/pokemons
HTTP 200


# body should have 7 pokemon articles
GET {{target}}
HTTP 200

[Asserts]
xpath "count(/html/body//div/*)" == 7.0
xpath "/html/body//div/*" count == 7.0


# create another pokemon
POST {{target}}/api/pokemons
HTTP 200


# should now have 8 pokemons
GET {{target}}
HTTP 200

[Asserts]
xpath "/html/body//div/*" count == 8.0