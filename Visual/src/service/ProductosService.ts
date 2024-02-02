import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {ProductosEntity} from "./ProductosEntity";

@Injectable({
  providedIn: 'root',
})
export class ProductosService {
  private apiUrl = 'http://localhost:8080/api/productos';

  constructor(private http: HttpClient) {
  }

  getAllProducts(): Observable<ProductosEntity[]> {
    return this.http.get<ProductosEntity[]>(this.apiUrl)
      .pipe(
        catchError(this.handleError)
      );
  }

  getProductById(id: number): Observable<ProductosEntity> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<ProductosEntity>(url)
      .pipe(
        catchError(this.handleError)
      );
  }

  filterProductsByName(clave: string): Observable<ProductosEntity[]> {
    const url = `${this.apiUrl}/filtrarPorNombre/${clave}`;
    return this.http.get<ProductosEntity[]>(url)
      .pipe(
        catchError(this.handleError)
      );
  }

  createProduct(producto: ProductosEntity): Observable<void> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<void>(this.apiUrl, producto, {headers})
      .pipe(
        catchError(this.handleError)
      );
  }

  modifyProduct(id: number, columna: string, valor: string): Observable<void> {
    // Codificar columnas y valores en la URL
    const url = `${this.apiUrl}/modificar/${id}/${encodeURIComponent(columna)}/${encodeURIComponent(valor)}`;
    const body = {};

    return this.http.post<void>(url, body)
      .pipe(
        catchError(this.handleError)
      );
  }

  deleteProduct(id: number): Observable<void> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete<void>(url)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // Error del lado del cliente
      console.error('Error del lado del cliente:', error.error.message);
    } else {
      // El servidor devolvió un código de error
      console.error(
        `Código de error del servidor: ${error.status}, ` +
        `body: ${JSON.stringify(error.error)}`
      );
    }
    // Devuelve un observable con un mensaje de error
    return throwError('Algo salió mal; por favor, inténtelo de nuevo más tarde.');
  }
}
