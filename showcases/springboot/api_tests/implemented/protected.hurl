# try protected endpoint with token
GET {{target}}/api/protected
Authorization: Bearer {{token}}


HTTP 200


# try protected endpoint with obv. wrong token
GET {{target}}/api/protected
Authorization: Bearer something wrong


HTTP 401


# try protected endpoint with token that has a wrong audience
GET {{target}}/api/protected
Authorization: Bearer {{wrong_token}}


HTTP 401