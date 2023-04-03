package ejercicio02;

import java.util.*;

public class Pedido {
	private Cliente cliente;
	private List<DetallePedido> detalle;

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		// this.detalle = new ArrayList<>();

	}

	public boolean abrirPedido() {
		if (!this.existePedido()) {
			this.detalle = new ArrayList<>();
			return true;
		} else {
			return false;
		}
	}

	public boolean existePedido() {
		return (this.detalle != null && this.detalle.size() > 0);
	}

	public void addProducto(Producto unProducto, Integer cantidad) {
		DetallePedido unPedido = new DetallePedido(unProducto, cantidad);
		this.detalle.add(unPedido);
	}

	public double promedio() {
		Double promedio = 0.0;
		Integer elementos = 0;
		if (this.existePedido() && (this.cantidadLineas() > 0)) {
			for (DetallePedido detalle : this.detalle) {
				elementos++;
				promedio += detalle.totalLinea();
			}
		}
		return (double) promedio / elementos;
	}

	public int cantidadLineas() {
		return this.detalle.size();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetallePedido> getDetalle() {
		return detalle;
	}

	public Producto masComprado() {
		Producto masComprado = new Producto();
		Integer elMayor = 0;
		if (this.existePedido() && (this.cantidadLineas() > 0)) {
			for (DetallePedido detalle : this.detalle) {
				if (elMayor == 0) {
					elMayor = detalle.getCantidad();
					masComprado = detalle.getProducto();
				} else {
					if (elMayor < detalle.getCantidad()) {
						elMayor = detalle.getCantidad();
						masComprado = detalle.getProducto();
					}
				}
			}
		}
		return masComprado;
	}
	
	public double totalPedido() {
		// A su vez el pedido tiene un método que retorna el subtotal
		// (el precio de cada línea de pedido) y el total, que es el subtotal mas el 21%
		// de IVA en caso de que
		// el cliente sea consumidor final.
		Double total = 0.0;
		if (this.existePedido() && (this.cantidadLineas() > 0)) {
			for (DetallePedido detalle : this.detalle) {
				total += detalle.totalLinea();
			}
		}

		return (this.cliente.getConsFinal()) ? total : total * 1.21;

	}
}
