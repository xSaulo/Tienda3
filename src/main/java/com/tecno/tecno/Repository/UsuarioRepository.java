package com.tecno.tecno.Repository;

import com.tecno.tecno.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

  Usuario findByUsername(String username);

}
