lsof -t -i:8090 | xargs -r kill
cargo run & 2>&1
hurl api_tests/implemented/healthz.hurl --retry 4 --delay 1000 --variables-file api_tests/variables --test
hurl api_tests/implemented/*.hurl {{hurl_opts}} --variables-file api_tests/variables --test	
lsof -t -i:8090 | xargs -r kill
echo "Verify done"