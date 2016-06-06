package pablofranco.org.aplicacion_turismo_android.Bean;

/**
 * Created by Pablo on 5/06/2016.
 */
public class Usuario {

    private Integer id_Usuario;
    private String nombre;
    private String correo;
    private String contraseña;
    private String nick;
    private Integer telefono;
    private String nacionalidad;
    private Integer id_Rol;
    private String token;
    private String exp;

    public Usuario(Integer id_Usuario, String nombre, String correo, String contraseña, String nick, Integer telefono, String nacionalidad, Integer id_Rol, String token, String exp) {
        this.id_Usuario = id_Usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.nick = nick;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
        this.id_Rol = id_Rol;
        this.token = token;
        this.exp = exp;
    }

    public Integer getId_Usuario() {
        return id_Usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNick() {
        return nick;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Integer getId_Rol() {
        return id_Rol;
    }

    public String getToken() {
        return token;
    }

    public String getExp() {
        return exp;
    }

    public void setId_Usuario(Integer id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setId_Rol(Integer id_Rol) {
        this.id_Rol = id_Rol;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public Usuario() {
    }
}

