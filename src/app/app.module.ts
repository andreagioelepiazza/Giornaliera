import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GiornalieraComponent } from './componenti/giornaliera/giornaliera.component';
import { LoginComponent } from './componenti/login/login.component';
import { LogoutComponent } from './componenti/logout/logout.component';
import { WelcomeComponent } from './componenti/welcome/welcome.component';
import { NavbarComponent } from './componenti/navbar/navbar.component';
import { FooterComponent } from './componenti/footer/footer.component';
import { ErrorComponent } from './componenti/error/error.component';
import { JumbotronComponent } from './componenti/jumbotron/jumbotron.component';
import { HttpClientModule } from '@angular/common/http';
import { SigninComponent } from './componenti/signin/signin.component';
import { DipendenteComponent } from './componenti/dipendente/dipendente.component';
import { GiornalieraEditComponent } from './componenti/giornaliera-edit/giornaliera-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    GiornalieraComponent,
    LoginComponent,
    LogoutComponent,
    WelcomeComponent,
    NavbarComponent,
    FooterComponent,
    ErrorComponent,
    JumbotronComponent,
    SigninComponent,
    DipendenteComponent,
    GiornalieraEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
