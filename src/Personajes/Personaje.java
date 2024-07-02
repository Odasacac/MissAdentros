package Personajes;

public class Personaje 
{//ATRIBUTOS
	private String nombre;
	private int clase;
	private String nombreClase;
	private int suerte; //No mayor de 10
	
	private int vida;
	private int vidaMaxima;
	private int ataque;
	private int defensa;
	
	//G&S
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(int clase)
	{
		switch (clase)
		{
		case 0:
			this.nombreClase="aventurero";
			
			break;
		case 1:
			this.nombreClase="guerrero";
			
			break;
		case 2:
			this.nombreClase="ladrón";
			break;
		case 3:
			this.nombreClase="mago";
			break;
		case 4:
			this.nombreClase="clérigo";
			break;
		case 5:
			this.nombreClase="berserk";
			break;
			
		}
	}
	
	public int getVidaMaxima() {
		return vidaMaxima;
	}
	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getClase() {
		return clase;
	}
	public void setClase(int clase) {
		this.clase = clase;
	}
	public int getSuerte() {
		return suerte;
	}
	public void setSuerte(int suerte) {
		this.suerte = suerte;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public Personaje (String nombre, int clase, int suerte, int vida, int ataque, int defensa) //Constructor
	{
		this.nombre=nombre;
		this.clase=clase;
		setNombreClase(clase);
		this.suerte=suerte;
		this.vida=vida;
		setVidaMaxima(vida);
		this.ataque=ataque;
		this.defensa=defensa;
	}
	
}
