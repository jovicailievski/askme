import { IQuestion } from './question';

export interface ICategory{
    id: number,
    name: string,
    questions: Array<IQuestion>
}