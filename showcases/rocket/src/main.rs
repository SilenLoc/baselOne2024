#![allow(clippy::let_unit_value)]

#[macro_use]
extern crate rocket;

mod auth;
mod pokedex;
mod poke_endpoints;

#[get("/healthz")]
fn healthz() {}

#[get("/protected")]
fn protected(_access_token: auth::AccessToken) {}

#[launch]
fn rocket() -> _ {
    let pokedex = pokedex::Pokedex::new();

    rocket::build()
        .attach(auth::fairing())
        .manage(pokedex)
        .mount("/api", routes![healthz, protected, poke_endpoints::get_all_pokemons])

}
