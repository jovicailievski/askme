import { logging } from 'protractor';
import { ICategory } from './category';
import { IUser } from './user';
import { IAnswer } from './answer';

export interface IQuestion{
    id: number,
    user:IUser,
    answers: Array<IAnswer>,
    title: string,
    description: string,
    category: ICategory
}