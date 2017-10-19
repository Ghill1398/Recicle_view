package net.sgoliver.android.recyclerview;

public class Alumno
{
    private String Nombre;
    private String Apellidos;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Alumno(String tit, String sub){
        Nombre = tit;
        Apellidos = sub;
    }

    public String getNombre(){
        return Nombre;
    }

    public String getApellidos(){
        return Apellidos;
    }
}
