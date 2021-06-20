import { NgModule } from '@angular/core';
import { Routes, RouterModule, ExtraOptions } from '@angular/router';
import { ProductListComponent } from './component/product-list/product-list.component';

const routes: Routes = [
  { path: 'category/:c', component: ProductListComponent},
  { path: 'product', component: ProductListComponent },
  { path: '', redirectTo: 'product', pathMatch: 'full' },
  { path: '**', redirectTo: 'notfound', pathMatch: 'full' },
];

const config: ExtraOptions = {
  useHash: true,
};

@NgModule({
  imports: [RouterModule.forRoot(routes, config)],
  exports: [RouterModule],
})
export class AppRoutingModule { }