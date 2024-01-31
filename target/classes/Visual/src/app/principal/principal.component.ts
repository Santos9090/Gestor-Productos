import {Component, Inject, OnInit} from '@angular/core';
import {ProductosService} from '../../service/ProductosService';
import {Router} from "@angular/router";
import {DOCUMENT} from "@angular/common";

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit {
  productos: any[] = [];
  showDropdown: boolean = false;
  filterType: string = 'id';
  filtroIdValue: number | undefined;
  filtroNombreValue: string = '';
  showErrorDialog: boolean = false;
  errorMessage: string = '';

  constructor(private productosService: ProductosService, private router: Router,@Inject(DOCUMENT) private document: Document) {
  }

  ngOnInit(): void {
    this.loadProducts();
  }


  toggleDropdown(type: string): void {
    if (!this.showDropdown) {
      // Se está cerrando el dropdown, vaciar los valores
      this.filtroIdValue = undefined;
      this.filtroNombreValue = '';
    }

    this.showDropdown = !this.showDropdown;
    this.filterType = type;
  }

  loadProducts() {
    this.productosService.getAllProducts().subscribe(
      (data: any[]) => {
        this.productos = data;
      },
      (error: any) => {
        console.error('Error loading products:', error);
        this.showError('Error cargando productos');
      }
    );
  }

  async eliminarProducto(id: number | undefined) {
    if (typeof id === "number") {
      try {
        await this.productosService.deleteProduct(id).toPromise();
        this.loadProducts();
      } catch (error) {
        console.error(`Error al eliminar el producto ${id}.`, error);
        // Muestra la pantalla de error si es necesario
        this.showError('Error al eliminar el producto. Consulta la consola para más detalles.');
      }
    } else {
      this.showError("Ha habido un error eliminando");
    }
  }

  IraInicio() {
    const element = this.document.documentElement;
    if (element) {
      element.scrollIntoView({ behavior: 'smooth', block: 'start', inline: 'nearest' });
    }
  }


  showError(message: string): void {
    this.errorMessage = message;
    this.showErrorDialog = true;
  }

  filtrarPorId() {
    if (typeof this.filtroIdValue === "number") {
      this.productosService.getProductById(this.filtroIdValue).subscribe(
        (data: any) => {
          this.productos = [data];
        },
        (error: any) => {
          console.error('Error filtering by ID:', error);
          this.showError('Error filtrando por ID');
        }
      );
    }
  }

  filtrarPorNombre() {
    if (this.filtroNombreValue.trim() !== '') {
      this.productosService.filterProductsByName(this.filtroNombreValue).subscribe(
        (data: any[]) => {
          this.productos = data;
        },
        (error: any) => {
          console.error('Error filtering by name:', error);
          this.showError('Error filtrando por nombre');
        }
      );
    }
  }

  irACrear(): void {
    this.router.navigate(['/Crear']); // Ajusta la ruta según la configuración de tu enrutador
  }

  closeErrorDialog(): void {
    this.showErrorDialog = false;
  }

  opciones: string[] = ['Nombre', 'Precio', 'Cantidad', 'Categoria'];
  seleccionPorProducto: any = {}; // Objeto para almacenar selecciones por producto
  nuevoValorPorProducto: any = {}; // Objeto para almacenar el nuevo valor por producto


  async modifyProducto(id: number) {
    try {
      const seleccion = this.seleccionPorProducto[id];
      const nuevoValor = this.nuevoValorPorProducto[id];
      if (
        ((seleccion === "Cantidad" || seleccion === "Precio") && nuevoValor && !isNaN(parseFloat(nuevoValor))) ||
        ((seleccion === "Nombre" || seleccion === "Categoria") && nuevoValor !== null && nuevoValor !== undefined && nuevoValor.trim() !== "")
      ) {
        await this.productosService.modifyProduct(id, seleccion, nuevoValor).toPromise();
        this.loadProducts();
      } else {
        console.error(`Error al modificar el producto ${id}. Verifica los valores ingresados.`);
        this.showError('Error al modificar el producto. Verifica los valores ingresados.');
      }
    } catch (error) {
      console.error(`Error al modificar el producto ${id}.`, error);
      // Muestra la pantalla de error si es necesario
      this.showError('Error al modificar el producto. Consulta la consola para más detalles.');
    }
  }


}
