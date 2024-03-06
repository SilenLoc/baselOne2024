#![allow(clippy::let_unit_value)]

#[macro_use]
extern crate rocket;

mod auth;

#[get("/healthz")]
fn healthz() {}

#[get("/protected")]
fn protected(_access_token: auth::AccessToken) {}

#[launch]
fn rocket() -> _ {
    rocket::build()
        .attach(auth::fairing())
        .mount("/api", routes![healthz, protected])
}
