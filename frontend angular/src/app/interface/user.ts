import { IUserRole } from './userrole';
import { IQuestion } from './question';
import { IAnswer } from './answer';

export interface IUser{
    id:number,
    username: string,
    password: string,
    userrole:IUserRole,
    questions: Array<IQuestion>,
    answers: Array<IAnswer>
}