export class ProductosEntity {
  id: number | undefined;
  nombre: string;
  precio: number;
  cantidad: number;
  categoria: string;

  constructor(
    nombre: string,
    precio: number,
    cantidad: number,
    categoria: string
  ) {
    this.nombre = nombre;
    this.precio = precio;
    this.cantidad = cantidad;
    this.categoria = categoria;
  }

  toString(): string {
    return `Productos{ id=${this.id}, nombre='${this.nombre}', precio=${this.precio}, cantidad=${this.cantidad}, categoria=${this.categoria} }`;
  }
}
