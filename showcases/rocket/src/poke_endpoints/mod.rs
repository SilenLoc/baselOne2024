use askama_rocket::Template;
use rocket::{http::{ContentType, Status}, State};
use crate::pokedex::{pokemon::Pokemon, Pokedex};



#[derive(Template)]
#[template(path = "pokemons.html")]
pub struct PokemonTemplate<'a> {
    pokemons: &'a Vec<Pokemon>,
}

#[get("/pokemons")]
pub fn get_all_pokemons(dex: &State<Pokedex>) -> PokemonTemplate<'static>  {
    let pokemons =  dex.inner().get_all();
     PokemonTemplate { &pokemons }
}