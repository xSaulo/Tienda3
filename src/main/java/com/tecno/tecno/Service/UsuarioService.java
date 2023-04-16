package com.tecno.tecno.Service;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecno.tecno.Model.Rol;
import com.tecno.tecno.Model.Usuario;
import com.tecno.tecno.Repository.UsuarioRepository;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {

  private UsuarioRepository usuarioRepository;

  public UsuarioService(UsuarioRepository usuarioRepository) {

    this.usuarioRepository = usuarioRepository;

  }

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) {

    // Se busca el usuario
    Usuario usuario = usuarioRepository.findByUsername(username);

    // Verificar que el usuario existe
    if (usuario == null) {

      throw new UsernameNotFoundException(username);

    }

    var roles = new ArrayList<GrantedAuthority>();

    for (Rol rol : usuario.getRol()) {

      roles.add(new SimpleGrantedAuthority(rol.getNombre()));

    }

    return new User(usuario.getUsername(), usuario.getPassword(), roles);

  }

}
