FROM clux/muslrust:1.76.0 AS chef
RUN cargo install cargo-chef

FROM chef AS planner
WORKDIR /app
COPY . .
RUN cargo chef prepare --recipe-path recipe.json

FROM chef AS builder
WORKDIR /app
COPY --from=planner /app/recipe.json recipe.json
RUN cargo chef cook --release --target x86_64-unknown-linux-musl --recipe-path recipe.json
COPY . .
RUN cargo build --release --target x86_64-unknown-linux-musl

FROM alpine:3.20.0 AS runtime
COPY --from=builder /app/target/x86_64-unknown-linux-musl/release/hurl-rocket /usr/local/bin/
ENV ROCKET_ADDRESS=0.0.0.0
EXPOSE 8001
CMD ["/usr/local/bin/hurl-rocket"]