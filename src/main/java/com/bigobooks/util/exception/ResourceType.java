package com.bigobooks.util.exception;

public enum ResourceType {

	ID("id"),
	CODE("código"),
	PURCHASE("compra"),
	SUPPLIER("proveedor"),
	AUTHOR("autor"),
	BOOK("libro"),
	GENRE("género"),
	STOCK_ADJUSTMENT("ajuste de stock"),
	WAREHOUSE("almacén"),
	COUPON("cupón"),
	ORDER("venta"),
	USER("usuario"),
	PROMOTION("promoción"),
	STOCK("stock"),
	RESOURCE("recurso");

	private final String label;

	ResourceType(String label) {
		this.label = label;
	}

	public String label() {
		return label;
	}
}
