import { BeverageService } from './../../services/beverage.service';
import { Beverage } from './../../models/beverage';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bev-list',
  templateUrl: './bev-list.component.html',
  styleUrls: ['./bev-list.component.css']
})
export class BevListComponent implements OnInit {
  title = 'Beverage Tracker';
  bevs: Beverage[] = [];
  selected = null;
  newBev = new Beverage();
  editBev: Beverage = null;
  id: number = null;

  constructor(private bevSvc: BeverageService) { }

  ngOnInit() {
    this.loadBevs();
  }

  loadBevs() {
    this.bevSvc.index().subscribe(
      (aGoodThingHappened) => {
        console.log(aGoodThingHappened);
        this.bevs = aGoodThingHappened;
      },
      (didntWork) => {
        console.log(didntWork);
      }
    );
  }

  displayBev() {

  }

}
