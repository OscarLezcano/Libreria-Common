# PROMPT — Diseño de pantallas para BigoBook

Soy estudiante de Ingeniería y estoy construyendo el backend de **BigoBook**, una tienda online de **venta física de libros**. El frontend lo vamos a diseñar después y necesito validar las pantallas antes de definir el modelo de datos en el backend.

## Contexto técnico

- Backend en Java + Spring Boot + JPA (Jakarta).
- Arquitectura de **microservicios**: `orders`, `purchases` y `shipping`, cada uno con su propia base de datos.
- Los microservicios se comunican por **eventos** (saga coreografiada, consistencia eventual). No hay transacciones distribuídas: `orders` publica `OrderPaid`, `shipping` escucha y crea un `Shipment`, etc.
- Las entidades se referencian entre servicios por **ID externo** (ej: `Shipment.orderId`), y los detalles guardan `bookId` + `bookName` (el catálogo de libros es un servicio externo).
- País: **Paraguay**. Impuestos con **IVA (10%)**, RUC, y facturación electrónica nacional **SIFEN / e-kuatia** (factura, boleta, nota de crédito).
- Pagos: **por banco, en un solo pago** (no hay pagos internos ni pasarela integrada). El estado del pedido marca: creación → pago confirmado → devuelto. osea la pasarela es la de bancard y punto

## Modelo de datos por microservicio

### 1. Orders (ventas)

- `Order`: `status` (PENDING, PAID, REFUNDED, CANCELLED), `totalPrice`, `promotion`, `orderDetails`.
- `OrderDetail`: `bookId`, `bookName`, `quantity`, `unitPrice`, `discount`.
- `Promotion`: `code`, `discountPercent`, `validUntil`, `status` (ACTIVE, EXPIRED, DISABLED).
- Relación m*m gestionada: `Order` ↔ libros vía `OrderDetail`.

### 2. Purchases (reposición de inventario)

- `Purchase`: `supplier`, `status` (PENDING, RECEIVED, CANCELLED), `subtotal`, `ivaAmount`, `totalPrice`, `discount`, `invoiceNumber`, `issuedAt`, `expectedArrivalDate`, `receivedAt`, `approvedById`, `note`, `purchaseDetails`.
- `PurchaseDetail`: `bookId`, `bookName`, `quantity`, `unitCost`.
- `Supplier`: `name`, RUC, contacto.
- `Invoice`: `purchase` (1:1), `documentType` (FACTURA, BOLETA, NOTA_CREDITO), `invoiceNumber`, `issueDate`, `vendorRuc`, `companyRuc`, `subtotal`, `ivaAmount`, `totalAmount`, `pdfUrl`.

### 3. Shipping (logística de ventas físicas)

- `Shipment`: `orderId` (externa), `approvedById`, `customerId`, `customerName`, `trackingNumber`, `shippingCost`, `status` (PROCESSING, PARTIALLY_SHIPPED, SHIPPED, DELIVERED, FAILED), `shippedAt`, `deliveredAt`, `failureReason`, dirección (department, city, referencePoint, recipientPhone), `shipmentDetails`.
- `ShipmentDetail`: `bookId`, `bookName`, `shippedQuantity`.
- `ShippingCompany`: `name`, `ruc`, `mail`.

## Flujos que deben cubrir las pantallas

- **Venta:** cliente pide → pago bancario confirmado → `Order.PAID` → `shipping` crea `Shipment` → despacho/entrega/fallo → `ShipmentStatus` cambia → eventos actualizan `Order`.
- **Compra/reposición:** pedido al proveedor → llega mercancía (`PENDING → RECEIVED`) → se registra factura con IVA.
- **Envío parcial:** un `Shipment` puede cubrir solo parte del pedido (`PARTIALLY_SHIPPED`).
- **Fallos de entrega:** `FAILED` con `failureReason`, reportado de vuelta a orders.

## Lo que necesito

1. Rediseñar las pantallas como **wireframes de alta calidad** (HTML/CSS), una por pantalla: Order, Purchase, Shipment, Invoice, más una **lista/tabla** para cada una (id, cliente/proveedor, estado, total, fecha) y filtros.
2. Validar si faltan campos o pantallas (ej: confirmar pago, devolución/refund, registrar fallo de envío).
3. Proponer el **orden de navegación** entre esas pantallas (flujo de usuario completo, rol staff/vendedor).
4. Agregar **reglas de validación** por campo (obligatorio, formato RUC/IVA, rangos) coherentes con Paraguay.
5. Sugerir cómo se ve la **integración entre microservicios** en la UI: ¿qué pantalla muestra el status compuesto? (ej: en Orders mostrar el estado del envío aunque viva en shipping).

Usá lenguaje claro, con nombres de campo idénticos a los del modelo. Respondé en español.