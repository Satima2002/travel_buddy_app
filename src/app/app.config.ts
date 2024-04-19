import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { provideHttpClient, withFetch, withJsonpSupport } from '@angular/common/http';
import { MessageService } from 'primeng/api';
import { AuthService } from './service/auth.service';

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes), provideClientHydration(), provideHttpClient(withFetch()), provideHttpClient(withJsonpSupport()), MessageService, AuthService]
};
