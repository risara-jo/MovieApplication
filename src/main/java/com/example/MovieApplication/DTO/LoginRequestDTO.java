package com.example.MovieApplication.DTO;

public class LoginRequestDTO {

    private String username;
    private String password;

    public LoginRequestDTO() {
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof LoginRequestDTO)) return false;
        final LoginRequestDTO other = (LoginRequestDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LoginRequestDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    public String toString() {
        return "LoginRequestDTO(username=" + this.getUsername() + ", password=" + this.getPassword() + ")";
    }
}
