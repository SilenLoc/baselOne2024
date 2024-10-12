use crate::pokedex::{
    pokemon::{DPokemon, Pokemon},
    Pokedex,
};
use askama::Template;
use rocket::http::ContentType;
use rocket::State;

#[derive(Template)]
#[template(path = "pokemons.html")]
pub struct PokemonTemplate {
    pokemons: Vec<DPokemon>,
}

#[get("/")]
pub fn get_all_pokemons(dex: &State<Pokedex>) -> (ContentType, String) {
    let pokemons: Vec<DPokemon> = dex.inner().get_all().into_iter().map(Into::into).collect();
    let html = PokemonTemplate { pokemons }.render().unwrap();
    (ContentType::HTML, html)
}

#[post("/pokemons")]
pub fn add_pokemons(dex: &State<Pokedex>) {
    let special = Pokemon::random();
    dex.inner().add(special);
}
