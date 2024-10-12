# try to get pokemons
GET {{target}}
HTTP 200

[Asserts]
xpath "string(/html/head/title)" contains "Pokédex"


POST {{target}}/api/pokemons
HTTP 200

POST {{target}}/api/pokemons
HTTP 200


# try to get pokemons
GET {{target}}
HTTP 200

[Asserts]
xpath "count(/html/body//div/*)" == 7.0
xpath "/html/body//div/*" count == 7.0


POST {{target}}/api/pokemons
HTTP 200


# try to get pokemons
GET {{target}}
HTTP 200

[Asserts]
xpath "/html/body//div/*" count == 8.0