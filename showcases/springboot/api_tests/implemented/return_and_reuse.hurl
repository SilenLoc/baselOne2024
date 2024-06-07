# try protected endpoint with token
GET {{target}}/api/protected/return
Authorization: Bearer {{token}}

HTTP *

[Captures]
return_text: body split "," nth 1 replace " " ""
[Asserts]
status >= 200
body endsWith "world!"


# try protected endpoint with token
GET {{target}}/api/protected/return?text={{return_text}}
Authorization: Bearer {{token}}

HTTP *

[Asserts]
status >= 200
body endsWith "world!!"