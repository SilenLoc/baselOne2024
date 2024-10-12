#![allow(clippy::let_unit_value)]

#[macro_use]
extern crate rocket;

mod assets;
mod auth;
mod poke_endpoints;
mod pokedex;

#[get("/healthz")]
fn healthz() {}

#[get("/protected")]
fn protected(_access_token: auth::AccessToken) {}

#[launch]
fn rocket() -> _ {
    let pokedex = pokedex::Pokedex::new();
    pokedex.fake_data();

    rocket::build()
        .attach(auth::fairing())
        .manage(pokedex)
        .mount("/_assets", assets::assets())
        .mount(
            "/api",
            routes![healthz, protected, poke_endpoints::add_pokemons],
        )
        .mount("/", routes![poke_endpoints::get_all_pokemons])
}
