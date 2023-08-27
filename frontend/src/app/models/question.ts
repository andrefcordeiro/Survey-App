export class Question {
  constructor(
    public id: number | undefined,
    public text: string,
    public options: string[]
  ) {}
}
