package ejercicio02;

public class Producto {
	
	private String descripcion;
	private  Integer codigo;
	private Double precio;
	private Unidad unidad;
	
	public enum Unidad {
		KILO, UNIDAD, LITRO, METRO
	}
	
	public Producto(String desc, Integer cod, double prec, Unidad unid) {
	        this.descripcion = desc;
	        this.codigo = cod;
	        this.precio = prec;
	        this.unidad = unid;
	    }
	   
	
	public Producto() {
        this.descripcion = "";
        this.codigo = 0;
        this.precio = 0.0;
        this.unidad = Unidad.UNIDAD;
    }
	
	public Unidad getUnidad() {
		return unidad;
	}


	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}


	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	};
}
