# wait for healthy
GET {{target}}/api/protected
Authorization: Bearer {{token}}


HTTP 200


# wait for healthy
GET {{target}}/api/protected
Authorization: Bearer something wrong


HTTP 401