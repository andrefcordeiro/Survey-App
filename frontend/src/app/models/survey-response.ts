import { QuestionResponse } from './question-response';

export class SurveyResponse {
  constructor(
    public surveyId: number,
    public questionsResponses: QuestionResponse[]
  ) {}
}
