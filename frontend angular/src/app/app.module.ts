import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { ProfileComponent } from './profile/profile.component';
import {HttpClientModule} from '@angular/common/http';
import { CategoryprobaComponent } from './categoryproba/categoryproba.component';
import { RegisterComponent } from './register/register.component';
import { CategoryService } from './category.service';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    routingComponents,
    ProfileComponent,
    CategoryprobaComponent,
    RegisterComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CategoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
