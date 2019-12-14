export class Beverage {
  id: number;
  name: string;
  description: string;
  ingredients: string;
  caffeinated: boolean;
  caffeine: number;
  containsAlcohol: boolean;
  calories: number;
  volume: number;
  active: boolean;
  createdAt: Date;
  updatedAt: Date;

  constructor(
    id?: number,
    name?: string,
    description?: string,
    ingredients?: string,
    caffeinated?: boolean,
    caffeine?: number,
    containsAlcohol?: boolean,
    calories?: number,
    volume?: number,
    active?: boolean,
    createdAt?: Date,
    updatedAt?: Date,
  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.ingredients = ingredients;
    this.caffeinated = caffeinated;
    this.caffeine = caffeine;
    this.containsAlcohol = containsAlcohol;
    this.calories = calories;
    this.volume = volume;
    this.active = active;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}
