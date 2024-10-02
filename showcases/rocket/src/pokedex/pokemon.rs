


#[derive(Clone, Debug)]
pub enum PokeType{
    Plant(),
    Poison(),
    
}

#[derive(Clone, Debug)]
pub struct Pokemon{
    id: String,
    name: String,
    types: Vec<PokeType>,
    evolutions: Box<Pokemon>
}

impl Pokemon {
    pub fn new(
        id: String,
        name: String,
        types: Vec<PokeType>,
        evolutions: Box<Pokemon>
    )-> Self{
        Self { id, name, types, evolutions }
    }
    
    pub fn id(&self)-> String{
        self.id.clone()
    }
}

