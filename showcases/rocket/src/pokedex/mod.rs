use std::{collections::HashMap, sync::{Arc, Mutex}};

use pokemon::Pokemon;

pub mod pokemon;

pub struct Pokedex{
    pokemons: Arc<Mutex<HashMap<String, Pokemon>>>
}

impl Pokedex {  
    
    pub fn new()-> Self{
        Self { pokemons: Arc::new(Mutex::new(HashMap::new())) }
    }
    
    pub fn add(&self, pokemon:Pokemon){
       let mut pokemons =  self.pokemons.lock().unwrap();
        pokemons.insert(pokemon.id(), pokemon);
    }
    
    pub fn get_all(&self)-> Vec<Pokemon>{
          self.pokemons.lock().unwrap().values().cloned().collect()
    }
}