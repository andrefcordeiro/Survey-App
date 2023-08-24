import { Question } from './question';

export class Survey {
  constructor(
    public id: number | undefined,
    public title: string | undefined,
    public timeframe: Date | undefined,
    public creationDate?: Date | undefined,
    public coordinatorId?: number | undefined,
    public coordinatorUsername?: number | undefined,
    public questions?: Question[] | undefined
  ) {}
}
