package ejercicio02;

public class DetallePedido {
	private Producto producto;
	private Integer cantidad;
	
	public DetallePedido(Producto unProducto, Integer cant) {
		this.producto = unProducto;
		this.cantidad = cant;
	}	
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public double totalLinea() {
		//retorna el precio de esa línea del pedido. 
		return ((Double) this.producto.getPrecio() * this.cantidad);
	}
}