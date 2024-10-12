use pokemon::Pokemon;
use std::{
    collections::HashMap,
    sync::{Arc, Mutex},
};

pub mod pokemon;

pub struct Pokedex {
    pokemons: Arc<Mutex<HashMap<String, Pokemon>>>,
}

impl Pokedex {
    pub fn new() -> Self {
        Self {
            pokemons: Arc::new(Mutex::new(HashMap::new())),
        }
    }

    pub fn fake_data(&self) {
        let mut pokemons = self.pokemons.lock().unwrap();
        let special1 = Pokemon::random();
        let special2 = Pokemon::random();
        pokemons.insert("99999999".to_string(), special1);
        pokemons.insert("999999991".to_string(), special2);
    }

    pub fn add(&self, pokemon: Pokemon) {
        let mut pokemons = self.pokemons.lock().unwrap();
        pokemons.insert(pokemon.id(), pokemon);
    }

    pub fn get_all(&self) -> Vec<Pokemon> {
        self.pokemons.lock().unwrap().values().cloned().collect()
    }
}
