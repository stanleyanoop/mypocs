import { Routes } from '@angular/router';

import { LoginUiComponent } from './login-ui/login-ui.component';
import { HomeUiComponent } from './home-ui/home-ui.component';

export const routes: Routes = [
    {
        path: '',
        title: 'Prayer Request Login Page',
        component: LoginUiComponent
    },
    {
        path:'home',
        title: 'Prayer Request Dashboard',
        component: HomeUiComponent
    }
];
