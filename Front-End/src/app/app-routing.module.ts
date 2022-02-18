import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DeleteComponent } from './delete/delete.component';
import { EditComponent } from './edit/edit.component';
import { InicialComponent } from './inicial/inicial.component';
import { ListaColaboradoresComponent } from './lista-colaboradores/lista-colaboradores.component';

const routes: Routes = [
  {path: '', redirectTo: 'inicial', pathMatch: 'full'},
  
  {path: 'inicial', component: InicialComponent},
  {path : 'lista', component: ListaColaboradoresComponent},
  

  {path: 'delete/:id', component: DeleteComponent},
  {path: 'edit/:id', component: EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
