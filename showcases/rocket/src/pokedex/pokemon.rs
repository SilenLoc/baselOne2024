use core::fmt;

use rand::{distributions::Alphanumeric, seq::IteratorRandom, Rng};

#[allow(unused)]
#[derive(Clone, Debug)]
pub enum PokeType {
    Plant(),
    Poison(),
}

impl fmt::Display for PokeType {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            PokeType::Plant() => write!(f, "Plant"),
            PokeType::Poison() => write!(f, "Poison"),
        }
    }
}

#[allow(unused)]
#[derive(Clone, Debug)]
pub struct Pokemon {
    pub id: String,
    pub name: String,
    pub types: Vec<PokeType>,
    pub evolutions: Box<Option<Pokemon>>,
}

#[derive(Clone, Debug)]
pub struct DPokemon {
    pub id: String,
    pub name: String,
    pub types: Vec<String>,
    pub evolutions: String,
}

impl From<Pokemon> for DPokemon {
    fn from(value: Pokemon) -> Self {
        Self {
            id: value.id(),
            name: value.name,
            types: value.types.iter().map(|t| t.to_string()).collect(),
            evolutions: match unbox(value.evolutions) {
                Some(p) => {
                    let dp: DPokemon = p.into();
                    dp.name
                }
                None => "none".to_string(),
            },
        }
    }
}

#[allow(clippy::boxed_local)]
fn unbox<T>(value: Box<T>) -> T {
    *value
}

impl Pokemon {
    pub fn random() -> Self {
        let mut rng = rand::thread_rng();
        let id = random_string();
        let name = random_string();
        let types = vec![PokeType::Plant, PokeType::Poison]
            .into_iter()
            .choose(&mut rng)
            .unwrap();
        let poke_type = types();
        let evo = if rand::random() {
            Some(Pokemon::random())
        } else {
            None
        };

        let evolutions = Box::new(evo);

        Self {
            id,
            name,
            types: vec![poke_type],
            evolutions,
        }
    }

    pub fn id(&self) -> String {
        self.id.clone()
    }
}

fn random_string() -> String {
    rand::thread_rng()
        .sample_iter(&Alphanumeric)
        .take(7)
        .map(char::from)
        .collect()
}
