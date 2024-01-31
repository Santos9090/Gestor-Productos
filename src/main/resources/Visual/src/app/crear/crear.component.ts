import {Component} from '@angular/core';
import {ProductosEntity} from "../../service/ProductosEntity";
import {ProductosService} from "../../service/ProductosService";
import {Router, RouterLink} from "@angular/router";
import {ErrorDialogComponent} from "../error-dialog/error-dialog.component";
import {NgIf} from "@angular/common";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-crear',
  standalone: true,
  imports: [
    RouterLink,
    ErrorDialogComponent,
    NgIf,
    FormsModule
  ],
  templateUrl: './crear.component.html',
  styleUrl: './crear.component.css'
})
export class CrearComponent {
  nuevoProducto: ProductosEntity = new ProductosEntity('', 1, 1, ''); // Instancia del nuevo producto

  constructor(
    private tuServicioExistente: ProductosService,private router: Router
  ) {
  }

  showErrorDialog: boolean = false;
  errorMessage: string = '';

  agregarProducto() {
    // Verifica que los campos necesarios estén llenos
    if (this.nuevoProducto.nombre && this.nuevoProducto.precio && this.nuevoProducto.cantidad && this.nuevoProducto.categoria) {
      // Llama al método del servicio para agregar el producto
      this.tuServicioExistente.createProduct(this.nuevoProducto)
        .subscribe(
          () => {
            // Limpia el nuevo producto después de agregarlo
            this.nuevoProducto = new ProductosEntity('', 0, 0, '');
          },
          error => {
            // Muestra el mensaje de error utilizando el servicio de ErrorDialog
            this.showError('Error al agregar el producto. Consulta la consola para más detalles.');
            console.error('Error al agregar el producto:', error);
          }
        );
      this.router.navigate(["/"])
    } else {
      // Puedes manejar una validación aquí, por ejemplo, mostrar un mensaje de error
      this.showError('Todos los campos son obligatorios');
    }
  }

  closeErrorDialog(): void {
    this.showErrorDialog = false;
  }

  showError(message: string): void {
    this.errorMessage = message;
    this.showErrorDialog = true;
  }

}
