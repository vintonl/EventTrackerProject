export class User {
  id: number;
  firstName: string;
  lastName: string;
  createdAt: Date;

  constructor(
    id?: number,
    firstName?: string,
    lastName?: string,
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
