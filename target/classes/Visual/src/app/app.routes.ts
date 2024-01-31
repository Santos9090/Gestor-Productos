// app-routing.module.ts
import {RouterModule, Routes} from '@angular/router';
import {NgModule} from "@angular/core";
import {PrincipalComponent} from "./principal/principal.component";
import {CrearComponent} from "./crear/crear.component";

export const routes: Routes = [
  {path: '', component: PrincipalComponent}, {path: 'Crear', component: CrearComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})], // Try adding { useHash: true }
  exports: [RouterModule],
})
export class AppRoutingModule {
}
