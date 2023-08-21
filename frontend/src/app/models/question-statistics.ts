export class QuestionStatistics {
  constructor(public optionNumber: number, public numberOfSelections: number) {}

  optionsSelectionCounts: Array<QuestionStatistics.OptionSelectionCount>;
}

export namespace QuestionStatistics {
  export class OptionSelectionCount {
    constructor(public questionId: number, public text: string) {}
  }
}
