package com.rods.meu_leitor.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rods.meu_leitor.entity.Usuario;

public class UsuarioDetails implements UserDetails{

    private final Usuario usuario;

    public UsuarioDetails(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return Collections.emptyList();
    }

    @Override
    public String getPassword()
    {
        return usuario.getSenha();
    }

    @Override
    public String getUsername()
    {
        return usuario.getEmail();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    
}
