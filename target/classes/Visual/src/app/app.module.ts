// app.module.ts
import {PrincipalComponent} from './principal/principal.component';
import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app.routes";
import {BrowserModule} from "@angular/platform-browser";
import {ErrorDialogComponent} from "./error-dialog/error-dialog.component";

@NgModule({
  declarations: [
    AppComponent,
    PrincipalComponent
  ], imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule, ReactiveFormsModule, ErrorDialogComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
