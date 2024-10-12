

hurl_opts := "--variables-file api_tests/variables --test"

# ---------------------------------------------------------------------------

# waits for healthy
wait-for-api:
	hurl api_tests/implemented/healthz.hurl --retry 4 --delay 1000 {{hurl_opts}}
	
# run acceptance tests against the running test stack
api-test *args: wait-for-api
    hurl api_tests/implemented/*.hurl {{hurl_opts}} {{args}}	

# ---------------------------------------------------------------------------

run-release: shutdown
    just run-q &  

# will run the server without the logs
[no-exit-message]
@run-q *args:
    cargo run {{args}} 2>&1

# shutdown whatever is running at the port    
shutdown:
    lsof -t -i:{{SERVER_PORT}} | xargs -r kill    

# ---------------------------------------------------------------------------
# compose the api_test
api_tests:
    #!/usr/bin/env bash
    just shutdown
    just run-release 2>&1
    just api-test
    just shutdown    