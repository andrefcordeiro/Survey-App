export class QuestionStatistics {
  constructor(public questionId: number, public text: string) {}

  optionSelectionCounts: Array<QuestionStatistics.OptionSelectionCount>;
}

export namespace QuestionStatistics {
  export class OptionSelectionCount {
    constructor(
      public optionNumber: number,
      public numberOfSelections: number
    ) {}
  }
}
