package com.example.portfolio.repositorio.interfaces;

import com.example.portfolio.modelo.Dominio.Usuario;

public interface I_RepoUsuario {
     Usuario saveUsuario (Usuario usuario);
     Usuario updateUsuario (Usuario usuario);
     Usuario usarioFindById (Usuario usuario);
     String deleteUsuario (String email);
}
