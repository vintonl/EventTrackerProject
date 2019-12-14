import { User } from './../../models/user';
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
  addForm = null;
  list = null;
  newBev = new Beverage();
  editBev: Beverage = null;
  id: number = null;
  user1 = new User(1);

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

  displayBev(bev: Beverage) {
    this.selected = bev;
  }

  setEditBev() {
    this.editBev = Object.assign({}, this.selected);
    console.log(this.editBev);
  }

  addBev() {
    this.newBev.user = this.user1;
    this.newBev.active = true;
    this.newBev.containsAlcohol = false;

    return this.bevSvc.create(this.newBev).subscribe(
      (good) => {
        this.loadBevs();
        this.newBev = new Beverage();
      },
      (bad) => {
        console.log('BevListComponent.addBev() error');
        console.log(bad);
      }
    );
  }

  editSubmit() {
    this.bevSvc.update(this.editBev).subscribe(
      (goodData) => {
        this.loadBevs();
        this.editBev = new Beverage();
        this.editBev = null;
        this.selected = goodData;
      },
      (bad) => {
        console.log('BevListComponent.editSubmit() error');
        console.log(bad);
      }
    );
  }

  deleteBev(id: number) {
    this.bevSvc.destroy(id).subscribe(
      (good) => {
        // console.log(good);
        this.loadBevs();
      },
      (bad) => {
        console.log('BevListComponent.deleteBev() error');
        console.log(bad);
      }
    );
  }

}
