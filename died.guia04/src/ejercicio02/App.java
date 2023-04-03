package ejercicio02;

import ejercicio02.Producto.Unidad;

public class App {

	public static void main(String[] args) {	
		Cliente cliente1 = new Cliente("Diego", "ddanelone@hotmail.com", 2024876678, true);
		Cliente cliente2 = new Cliente("Jorge", "jorgito@algo.com", 2035655525, false);

		Pedido pedido1 = new Pedido(cliente1);
		Pedido pedido2 = new Pedido(cliente2);

		Producto producto1 = new Producto("Coca Cola", 1111, 450.99, Unidad.UNIDAD);
		Producto producto2 = new Producto("Fanta", 2222, 399.99, Unidad.UNIDAD);
		Producto producto3 = new Producto("Manzanas", 3333, 699.99, Unidad.KILO);
		Producto producto4 = new Producto("Jabón Líquido", 4444, 450.00, Unidad.LITRO);

		cliente1.iniciarPedido(pedido1, producto1, 5);
		cliente1.agregarProducto(pedido1, producto2, 9);
		cliente1.agregarProducto(pedido1, producto3, 6);
		cliente1.agregarProducto(pedido1, producto4, 2);
		cliente1.confirmarPedido(pedido1);

		cliente1.iniciarPedido(pedido2, producto1, 1);
		cliente1.agregarProducto(pedido2, producto2, 1);
		cliente1.agregarProducto(pedido2, producto3, 1);
		cliente1.agregarProducto(pedido2, producto4, 1);
		cliente1.agregarProducto(pedido2, producto2, 1);
		cliente2.confirmarPedido(pedido2);

		System.out.println(
				"Costo Promedio cliente: " + cliente1.getNombre() + ": " + String.format("%.2f", cliente1.costoPromedioPedido(pedido1)));
		System.out.println(
				"Costo Promedio cliente: " + cliente2.getNombre() + ": " + String.format("%.2f",  cliente2.costoPromedioPedido(pedido2)));
		
		System.out.println("Producto más vendido: " + cliente1.productoMasComprado(pedido1).getDescripcion());
		
		

		System.out.println("Total del pedido 1: " + String.format("%.2f", cliente1.totalPedido(pedido1)));
		System.out.println("Total del pedido 2: " + String.format("%.2f",cliente2.totalPedido(pedido2)));

		cliente1.confirmarPedido(pedido1);
		cliente1.confirmarPedido(pedido2);

	}

}
