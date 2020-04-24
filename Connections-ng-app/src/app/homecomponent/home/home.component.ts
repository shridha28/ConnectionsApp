import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  images = [180,0, 366].map((n) => `https://picsum.photos/id/${n}/1300/500`);
  constructor() { }

  ngOnInit(): void {
  }

}
