package com.example.MovieApplication.DTO;

import java.util.Set;

public class LoginResponseDTO {

    private String jwtToken;
    private Long id;
    private String username;
    private String email;
    private Set<String> roles;

    LoginResponseDTO(String jwtToken, Long id, String username, String email, Set<String> roles) {
        this.jwtToken = jwtToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public static LoginResponseDTOBuilder builder() {
        return new LoginResponseDTOBuilder();
    }

    public String getJwtToken() {
        return this.jwtToken;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public Set<String> getRoles() {
        return this.roles;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof LoginResponseDTO)) return false;
        final LoginResponseDTO other = (LoginResponseDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$jwtToken = this.getJwtToken();
        final Object other$jwtToken = other.getJwtToken();
        if (this$jwtToken == null ? other$jwtToken != null : !this$jwtToken.equals(other$jwtToken)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$roles = this.getRoles();
        final Object other$roles = other.getRoles();
        if (this$roles == null ? other$roles != null : !this$roles.equals(other$roles)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LoginResponseDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $jwtToken = this.getJwtToken();
        result = result * PRIME + ($jwtToken == null ? 43 : $jwtToken.hashCode());
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $roles = this.getRoles();
        result = result * PRIME + ($roles == null ? 43 : $roles.hashCode());
        return result;
    }

    public String toString() {
        return "LoginResponseDTO(jwtToken=" + this.getJwtToken() + ", id=" + this.getId() + ", username=" + this.getUsername() + ", email=" + this.getEmail() + ", roles=" + this.getRoles() + ")";
    }

    public static class LoginResponseDTOBuilder {
        private String jwtToken;
        private Long id;
        private String username;
        private String email;
        private Set<String> roles;

        LoginResponseDTOBuilder() {
        }

        public LoginResponseDTOBuilder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public LoginResponseDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public LoginResponseDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public LoginResponseDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public LoginResponseDTOBuilder roles(Set<String> roles) {
            this.roles = roles;
            return this;
        }

        public LoginResponseDTO build() {
            return new LoginResponseDTO(this.jwtToken, this.id, this.username, this.email, this.roles);
        }

        public String toString() {
            return "LoginResponseDTO.LoginResponseDTOBuilder(jwtToken=" + this.jwtToken + ", id=" + this.id + ", username=" + this.username + ", email=" + this.email + ", roles=" + this.roles + ")";
        }
    }
}
