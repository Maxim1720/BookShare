package ru.simbirsoft.BookGo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.simbirsoft.BookGo.entity.User;
import ru.simbirsoft.BookGo.utill.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityUser implements UserDetails {
    public SecurityUser(String username, String password, List<SimpleGrantedAuthority> authorities, boolean enabled) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;
    private final boolean enabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public static UserDetails mapToUserDetails(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(),
                user.isEnabled(),
                user.isEnabled(),
                user.isEnabled(),
                convertToAuthority(user)        // TODO: добавить для каждого пользователя authority и permissions
        );
    }

    /**
     * Метод - заглушка.
     * Используется для определения уровня доступа конкретного пользователя.
     * Предполагается, что логика этого процесса будет перенесена в enum, который
     * будет назначать пользователю по уровню доступа - дозволяемые действия на ресурсах.
     *
     * @param user      пользователь из БД
     * @return          набор
     */
    private static Collection<? extends GrantedAuthority> convertToAuthority(User user) {
        String role = user.isStaff() ?
                (user.isSuperAdmin() ?
                        Role.SUPER_ADMIN.name() : Role.ADMIN.name()) :
                Role.USER.name();
        List<GrantedAuthority> authority =  new ArrayList<>();
        authority.add(new SimpleGrantedAuthority(role));

        return authority;
    }

}
