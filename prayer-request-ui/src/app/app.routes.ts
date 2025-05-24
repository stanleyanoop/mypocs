import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { LoginUiComponent } from './login-ui/login-ui.component';
import { HomeUiComponent } from './home-ui/home-ui.component';
import { PrayerReqUiComponent } from './prayer-req-ui/prayer-req-ui.component';

export const routes: Routes = [
    {
        path: '',
        title: 'Prayer Request Login Page',
        component: LoginUiComponent
    },
    {
        path:'home',
        title: 'Prayer Request Dashboard',
        component: HomeUiComponent,
        children: [
            {
                path:'prayerRequest/:id',
                title: 'Create/Edit Prayer Request',
                component: PrayerReqUiComponent
            }
        
        ]
    },
    {
        path:'prayerRequest/:id',
        title: 'Edit Prayer Request',
        component: PrayerReqUiComponent
    }
];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
    })
export class AppRoutingModule {}
