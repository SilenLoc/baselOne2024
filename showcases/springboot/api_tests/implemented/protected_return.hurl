# try protected endpoint with token
GET {{target}}/api/protected/return
Authorization: Bearer {{token}}

HTTP *

[Asserts]
status >= 200
body endsWith "world!"


# try protected endpoint with token
GET {{target}}/api/protected/return?text=baselone
Authorization: Bearer {{token}}

HTTP *

[Asserts]
status >= 200
body endsWith "baselone!"



# try protected endpoint without token
GET {{target}}/api/protected/return
Authorization: Bearer something wrong


HTTP 401