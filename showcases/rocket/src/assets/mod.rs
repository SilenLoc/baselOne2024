use rocket::fs::{relative, FileServer, Options};

pub fn assets() -> FileServer {
    FileServer::new(relative!("/assets"), Options::default())
}
