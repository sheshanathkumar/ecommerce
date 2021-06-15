import { NgModule } from '@angular/core';
import { Routes, RouterModule, ExtraOptions } from '@angular/router';
import { ProductListComponent } from './component/product-list/product-list.component';

const routes: Routes = [
  { path: 'product', component: ProductListComponent },
  
  // {
  //   path: 'pages',
  //   loadChildren: () =>
  //     import('../app/pages/pages.module').then((m) => m.PagesModule), // , canActivate: [AuthGuard]
  // },
  { path: '', redirectTo: 'product', pathMatch: 'full' },
  //{ path: '**', redirectTo: 'notfound' },
];

const config: ExtraOptions = {
  useHash: true,
};

// @NgModule({
//   imports: [RouterModule.forRoot(routes, config)],
//   exports: [RouterModule],
// })

@NgModule({
  imports: [RouterModule.forRoot(routes, config)],
  exports: [RouterModule],
})
export class AppRoutingModule { }