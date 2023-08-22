import { QuestionStatistics } from './question-statistics';

export class Survey {
  constructor(
    public id: number,
    public title: string,
    public timeframe: Date,
    public creationDate: string,
    public coordinatorId: number,
    public coordinatorUsername: number,
    public questionsStatistics: QuestionStatistics[]
  ) {}

  questions: Array<Survey.Question>;
}

export namespace Survey {
  export class Question {
    constructor(
      public id: number,
      public text: string,
      public options: string[]
    ) {}
  }
}
