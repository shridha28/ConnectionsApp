import {
    trigger,
    state,
    style,
    animate,
    transition,
    query,group,
    animateChild
  } from '@angular/animations';


export const slideInAnimation =
  trigger('routeAnimations', [
    transition('* => *', [
        query(':enter, :leave', 
             style({ position: 'fixed', width: '100%' }), 
             { optional: true }),        
        group([
             query(':enter',[
                 style({ transform: 'translateX(-100%)' }),
                 animate('0.25s ease-in', 
                 style({ transform: 'translateX(0%)' })),
             ], { optional: true }),
             query(':leave', [
                 style({ transform:   'translateX(0%)'}),
                 animate('0.25s ease-in', 
                 style({ transform: 'translateX(100%)' }))
             ], { optional: true }),
        ])
   ]),


    transition('* <=> FilterPage', [
      style({ position: 'relative' }),
      query(':enter, :leave', [
        style({
          position: 'absolute',
          top: 0,
          left: 0,
          width: '100%'
        })
      ]),
      query(':enter', [
        style({ left: '-100%'})
      ]),
      query(':leave', animateChild()),
      group([
        query(':leave', [
          animate('200ms ease-out', style({ left: '100%'}))
        ]),
        query(':enter', [
          animate('300ms ease-out', style({ left: '0%'}))
        ])
      ]),
      query(':enter', animateChild()),
    ])
  ]);


  