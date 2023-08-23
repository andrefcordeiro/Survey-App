import { QuestionStatistics } from './question-statistics';

export class Survey {
  constructor(
    public id: number | undefined,
    public title: string | undefined,
    public timeframe: Date | undefined,
    public creationDate?: string | undefined,
    public coordinatorId?: number | undefined,
    public coordinatorUsername?: number | undefined,
    public questions?: Array<Survey.Question> | undefined,
    public questionsStatistics?: QuestionStatistics[]
  ) {}
}

export namespace Survey {
  export class Question {
    constructor(
      public id: number | undefined,
      public text: string,
      public options: string[]
    ) {}
  }
}
