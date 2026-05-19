public class Estudianre extends Persona {
    private String carrera;

    public Estudianre(String cedula, String nombreCompleto, int edad, String carrera) {
        super(cedula, nombreCompleto, edad);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    @Override
    public void mostrarDatos(){
        System.out.println("Tipo: Estudiante");
        super.mostrarDatos();
        System.out.println("Carrera"+carrera);
    }
}
