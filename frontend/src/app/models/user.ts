import { UserRole } from './enums/user-role';

export class User {
  constructor(
    public id: number | undefined,
    public name: string | undefined,
    public email: string | undefined,
    public username: string,
    public password: string,
    public role: UserRole | undefined
  ) {}
}
