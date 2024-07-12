import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './componenti/login/login.component';
import { WelcomeComponent } from './componenti/welcome/welcome.component';
import { ErrorComponent } from './componenti/error/error.component';
import { GiornalieraComponent } from './componenti/giornaliera/giornaliera.component';
import { LogoutComponent } from './componenti/logout/logout.component';
import { RouteGuardServiceService } from './service/route-guard-service.service';
import { SigninComponent } from './componenti/signin/signin.component';
import { DipendenteComponent } from './componenti/dipendente/dipendente.component';
import { GiornalieraEditComponent } from './componenti/giornaliera-edit/giornaliera-edit.component';

const routes: Routes = [
  {path:"", component: LoginComponent},
  {path:"signin", component: SigninComponent},
  {path:"login", component: LoginComponent},
  {path:"welcome", component: WelcomeComponent, canActivate:[RouteGuardServiceService]},
  {path:"giornaliera", component: GiornalieraComponent, canActivate:[RouteGuardServiceService]},
  {path:"giornalieraEdit", component: GiornalieraEditComponent, canActivate:[RouteGuardServiceService]},
  {path:"dipendente", component: DipendenteComponent, canActivate:[RouteGuardServiceService]},
  {path: "logout", component: LogoutComponent, canActivate:[RouteGuardServiceService]},
  {path:"**", component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
