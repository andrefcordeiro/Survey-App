import { QuestionStatistics } from './question-statistics';

export class Survey {
  constructor(
    public id: number,
    public title: string,
    public timeframe: Date,
    public creationDate: string,
    public questionsSatistics: QuestionStatistics[]
  ) {}
}
