# try to get pokemons
GET {{target}}
HTTP 200

[Asserts]
xpath "string(/html/head/title)" contains "Pokédex"