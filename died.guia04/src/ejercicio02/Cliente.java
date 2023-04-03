package ejercicio02;

public class Cliente {
	private String nombre;
	private String email;
	private Long cuit;
	private Boolean consFinal;

	public Cliente(String nombre, String email, long cuit, Boolean consFinal) {
		this.nombre = nombre;
		this.email = email;
		this.cuit = cuit;
		this.consFinal = consFinal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public Boolean getConsFinal() {
		return consFinal;
	}

	public void setConsFinal(Boolean consFinal) {
		this.consFinal = consFinal;
	}

	public boolean iniciarPedido(Pedido unPedido, Producto unProducto, Integer cantidad) {
		// abre un pedido y permite agregar productos al pedido y retorna true si esto
		// es posible o false si ya existe un pedido abierto
		Boolean existe = unPedido.abrirPedido();
		if (existe) {
			unPedido.addProducto(unProducto, cantidad);
		}
		return existe;
	}

	public boolean agregarProducto(Pedido unPedido, Producto unProducto, Integer cantidad) {
		// si un pedido esta abierto, agrega un producto y la cantidad indicada recibida
		// como parámetro al pedido actual y retorna true. Si no hay pedido abierto
		// retorna false
		Boolean abierto = unPedido.existePedido();
		if (abierto) {
			unPedido.addProducto(unProducto, cantidad);
		}
		return abierto;
	}

	public boolean confirmarPedido(Pedido unPedido) {
		// si hay un pedido abierto y tiene al menos un producto agrega el pedido a la
		// lista de
		// pedidos, pone en null el pedido actual y retorna true. Caso contrario retorna
		// false.
		if (unPedido.existePedido() && (unPedido.cantidadLineas() > 0)) {
			unPedido = null;
			return true;
		} else {
			return false;
		}
	}

	public double costoPromedioPedido(Pedido unPedido) {
		// calcula el costo promedio de todas las compras que realizó el cliente
		Double promedio = 0.0;
		if (unPedido.existePedido() && (unPedido.cantidadLineas() > 0)) {
			return promedio = unPedido.promedio();
			
		}
		return promedio;
	}
	public double totalPedido(Pedido unPedido) {
		return unPedido.totalPedido();
	}

	public Producto productoMasComprado(Pedido unPedido) {
		// busca el producto cuya cantidad en unidades es la mayor que se ha comprado
		// (por ejemplo compro en total 60 litros de agua y 40 kg de pan, el producto mas comprado
		// son 60 litros de agua).
		 return unPedido.masComprado();
	}
}
