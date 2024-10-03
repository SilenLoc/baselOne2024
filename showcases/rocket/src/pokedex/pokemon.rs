use core::fmt;

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
    pub fn new(
        id: String,
        name: String,
        types: Vec<PokeType>,
        evolutions: Box<Option<Pokemon>>,
    ) -> Self {
        Self {
            id,
            name,
            types,
            evolutions,
        }
    }

    pub fn id(&self) -> String {
        self.id.clone()
    }
}
