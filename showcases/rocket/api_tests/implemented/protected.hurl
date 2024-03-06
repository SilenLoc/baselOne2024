# try protected endpoint with token
GET {{target}}/api/protected
Authorization: Bearer {{token}}


HTTP 200


# try protected endpoint without token
GET {{target}}/api/protected
Authorization: Bearer something wrong


HTTP 401