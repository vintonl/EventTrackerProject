import { User } from './../../models/user';
import { BeverageService } from './../../services/beverage.service';
import { Beverage } from './../../models/beverage';
import { Component, OnInit, NgModule } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-bev-list',
  templateUrl: './bev-list.component.html',
  styleUrls: ['./bev-list.component.css']
})
export class BevListComponent implements OnInit {
  title = 'Beverage Tracker';
  bevs: Beverage[] = [];
  searchBevs: Beverage[] = [];
  selected = null;
  addForm = null;
  list = null;
  newBev = new Beverage();
  editBev: Beverage = null;
  id: number = null;
  user1 = new User(1);
  keyword: string = null;
  dateSearch: Date = null;
  dateSearchTotals = null;
  searchResult: null;
  hideSearchResult = false;
  totalBevs = 0;
  totalCaffeine = 0;
  totalCalories = 0;
  totalVolume = 0;

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


  search() {
    this.clearSearch();
    this.loadBevs();
    this.resetTotals();

    // tslint:disable-next-line: prefer-for-of
    for (let i = 0; i < this.bevs.length; i++) {
      if (this.bevs[i].name.includes(this.keyword)) {
        this.searchBevs.push(this.bevs[i]);
        this.totalBevs++;
        this.totalCaffeine += this.bevs[i].caffeine;
        this.totalCalories += this.bevs[i].calories;
        this.totalVolume += this.bevs[i].volume;
        continue;
      }
      if (this.bevs[i].description && this.bevs[i].description.includes(this.keyword)) {
        this.searchBevs.push(this.bevs[i]);
        this.totalBevs++;
        this.totalCaffeine += this.bevs[i].caffeine;
        this.totalCalories += this.bevs[i].calories;
        this.totalVolume += this.bevs[i].volume;
        continue;
      }
      if (this.bevs[i].ingredients && this.bevs[i].ingredients.includes(this.keyword)) {
        this.searchBevs.push(this.bevs[i]);
        this.totalBevs++;
        this.totalCaffeine += this.bevs[i].caffeine;
        this.totalCalories += this.bevs[i].calories;
        this.totalVolume += this.bevs[i].volume;
      }

    }
    if (this.searchBevs.length === 0) {
      this.hideSearchResult = true;
    } else {
      this.hideSearchResult = false;
    }
    this.keyword = null;
  }

  searchDate() {
    this.clearSearch();
    this.loadBevs();
    this.resetTotals();

    // tslint:disable-next-line: prefer-for-of
    for (let i = 0; i < this.bevs.length; i++) {
      if (this.bevs[i].createdAt === this.dateSearch) {
        this.searchBevs.push(this.bevs[i]);
        this.totalBevs++;
        this.totalCaffeine += this.bevs[i].caffeine;
        this.totalCalories += this.bevs[i].calories;
        this.totalVolume += this.bevs[i].volume;
      }
    }

    if (this.searchBevs.length === 0) {
      this.hideSearchResult = true;
    } else {
      this.hideSearchResult = false;
    }
    this.keyword = null;
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

  private resetTotals() {
    this.totalBevs = 0;
    this.totalCaffeine = 0;
    this.totalCalories = 0;
    this.totalVolume = 0;
  }

  private clearSearch() {
    this.searchBevs = [];
  }
}
